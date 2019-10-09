package com.capgemini.cn.core.utils;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.SecureRandom;
import java.util.*;

public class IdUtil {
    // 纳秒id的ip截取位数
    private static final int NANOTIME_IP_SUBSIZE = 3;

    /**
     * 封装JDK自带的UUID, 通过Random数字生成,中间有-分割
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static long getSnowFlakeId() {
        return SnowflakeKeyWorker.nextId();
    }

    public static String getSnowFlakeStrId() {
        return SnowflakeKeyWorker.nextId()+"";
    }

    public static void main(String[] args) {
        System.out.println("uuid:" + getUUID());
        System.out.println("getSnowFlakeId:" + getSnowFlakeId());
        System.out.println("getSnowFlakeIdStr:" + getSnowFlakeStrId());
    }
}
