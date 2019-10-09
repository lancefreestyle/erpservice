package com.capgemini.cn.core.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class SnowflakeKeyWorker {
    /**
     *
     * Twitter_Snowflake：分布式ID生成雪花算法<br>
     * https://blog.csdn.net/li396864285/article/details/54668031
     * https://gblog.sherlocky.com/xue-hua-suan-fa-snowflake/
     *
     * SnowFlake的结构如下(每部分用-分开):<br>
     * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 -
     * 000000000000 <br>
     *
     * 1位标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id一般是正数，最高位是0<br>
     * 41位时间截(毫秒级)，注意，41位时间截不是存储当前时间的时间截，而是存储时间截的差值（当前时间截 - 开始时间截)
     * 得到的值），这里的的开始时间截，一般是我们的id生成器开始使用的时间，由我们程序来指定的（如下下面程序IdWorker类的startTime属性）。
     * 41位的时间截，可以使用69年，年T = (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69<br>
     * 10位的数据机器位，可以部署在1024个节点，包括5位datacenterId和5位workerId<br>
     * 12位序列，毫秒内的计数，12位的计数顺序号支持每个节点每毫秒(同一机器，同一时间截)产生4096个ID序号<br>
     * 加起来刚好64位，为一个Long型。<br>
     * SnowFlake的优点是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞(由数据中心ID和机器ID作区分)，并且效率较高，经测试，
     * SnowFlake每秒能够产生26万ID左右。
     */

    /** 开始时间截 (2019-01-01) */
    private static final long TWEPOCH = 1546272000000L;

    // 机器标识位数
    private static final long WORKERIDBITS = 5L;
    // 数据中心标识位数
    private static final long DATACENTERIDBITS = 5L;

    // 毫秒内自增位数
    private static final long SEQUENCEBITS = 12L;
    // 机器ID偏左移12位
    private static final long WORKERIDSHIFT = SEQUENCEBITS;
    // 数据中心ID左移17位
    private static final long DATACENTERIDSHIFT = SEQUENCEBITS + WORKERIDBITS;
    // 时间毫秒左移22位
    private static final long TIMESTAMPLEFTSHIFT = SEQUENCEBITS + WORKERIDBITS + DATACENTERIDBITS;
    // sequence掩码，确保sequnce不会超出上限
    private static final long SEQUENCEMASK = -1L ^ (-1L << SEQUENCEBITS);
    // 上次时间戳
    private static long lastTimestamp = -1L;
    // 序列
    private long sequence = 0L;
    // 服务器ID
    private long workerId = 1L;

    /**
     * 如何确保不超出位数限制,我们拿workerId举个例子：this.workerId=workerId & workerMask;
     */
    /**
     * workerMask 是啥 ??? 它先执行的是-1L << workerIdBits，workerIdBits是5。这又是什么意思呢？
     * 注意，这是位运算，long用的是补码， -1L，就是64个1，这里使用-1是为了格式化所有位数 ===>
     * 11111...(省略54个1)...11111
     * <<是左移运算，-1L左移五位，低位补零，也就是左移空出来的会自动补0，于是就低位五位是0，其余是1。 ===>
     * 11111...(省略54个1)...00000
     * 然后^这个符号，是异或，也是位运算，位上相同则为0，不通则为1，和-1做异或，则把所有的0和1颠倒了一下。 ===>
     * 00000...(省略54个0)...11111
     *
     * 这时候，我们再看，workerId & workerMask，与操作，两个位上都为1的才能唯一，否则为零，
     * workerMask高位都是0，所以，不管workerId高位是什么，都是0；
     * 而workerMask低位都是1，所以，不管workerId低位是什么，都会被保留，于是，我们就控制了workerId的范围。
     */
    private static long workerMask = -1L ^ (-1L << WORKERIDBITS);
    // 进程编码
    private long processId = 1L;
    private static long processMask = -1L ^ (-1L << DATACENTERIDBITS);
    private static SnowflakeKeyWorker keyWorker = null;

    static {
        keyWorker = new SnowflakeKeyWorker();
    }

    public static synchronized long nextId() {
        return keyWorker.getNextId();
    }

    private SnowflakeKeyWorker() {

        // 获取机器编码
        this.workerId = this.getMachineNum();
        // 获取进程编码
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        this.processId = Long.valueOf(runtimeMXBean.getName().split("@")[0]).longValue();

        // 避免编码超出最大值
        this.workerId = workerId & workerMask;
        this.processId = processId & processMask;
    }

    // 最后的异常
    /**
     * 这里，时间戳，保证了不通毫秒不同，然后机器编码进程编码保证了不同进程不通，
     * 再然后，序列，在同一毫秒内，如果获取第二个ID，则序列号+1，到下一毫秒后重置。至此，唯一性ok。
     *
     * 但是，还有问题，序列号用完了怎么办？代码里的解决方案是，等到下一毫秒。
     */
    private synchronized long getNextId() {
        // 获取时间戳
        long timestamp = timeGen();
        // 如果时间戳小于上次时间戳则报错
        if (timestamp < lastTimestamp) {
            try {
                throw new Exception("Clock moved backwards.  Refusing to generate id for " + (lastTimestamp - timestamp)
                        + " milliseconds");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 如果时间戳与上次时间戳相同
        if (lastTimestamp == timestamp) {
            // 当前毫秒内，则+1，与sequenceMask确保sequence不会超出上限
            sequence = (sequence + 1) & SEQUENCEMASK;
            if (sequence == 0) {
                // 当前毫秒内计数满了，则等待下一秒
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = timestamp;
        // ID偏移组合生成最终的ID，并返回ID（原始算法中时间戳占41位，该算法占42位。。）
        return ((timestamp - TWEPOCH) << TIMESTAMPLEFTSHIFT) | (processId << DATACENTERIDSHIFT)
                | (workerId << WORKERIDSHIFT) | sequence;
    }

    /**
     * 再次获取时间戳直到获取的时间戳与现有的不同
     *
     * @param lastTimestamp
     * @return 下一个时间戳
     */
    private long tilNextMillis(final long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * 获取机器编码
     */
    private long getMachineNum() {
        long machinePiece;
        StringBuilder sb = new StringBuilder();
        Enumeration<NetworkInterface> e = null;
        try {
            e = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e1) {
            e1.printStackTrace();
        }
        while (e.hasMoreElements()) {
            NetworkInterface ni = e.nextElement();
            sb.append(ni.toString());
        }
        machinePiece = sb.toString().hashCode();
        return machinePiece;
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
			long id = nextId();
			System.out.println(id);
		}
    }

}
