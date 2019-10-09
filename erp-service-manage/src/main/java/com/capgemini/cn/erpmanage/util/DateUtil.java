package com.capgemini.cn.erpmanage.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DateUtil {

    private static Date parse(String date, String format) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static Date roundToDay(Date date) {
        date = roundToHour(date);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.set(Calendar.HOUR_OF_DAY, 0);
        return gc.getTime();
    }

    private static Date roundToHour(Date date) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.set(Calendar.MINUTE, 0);
        gc.set(Calendar.SECOND, 0);
        gc.set(Calendar.MILLISECOND, 0);
        return gc.getTime();
    }

    private static int getTimeField(Date date, int field) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        return gc.get(field);
    }

    private static Date add(Date date, int field, int amount) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(field, amount);
        return gc.getTime();
    }

    public static String format(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        if (date == null) {
            return "";
        }
        return df.format(date);
    }

    public static String toSeconds(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String toMinute(Date date) {
        return format(date, "yyyy-MM-dd HH:mm");
    }

    public static String toDay(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    public static String toDateAll(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String toShortDay(Date date) {
        return format(date, "yyyyMMdd");
    }

    public static String toMonth(Date date) {
        return format(date, "MM");
    }

    public static String toShortdd(Date date) {
        return format(date, "dd");
    }

    public static String toShortSeconds(Date date) {
        return format(date, "HH:mm:ss");
    }

    public static String toShortYear(Date date) {
        return format(date, "yyyy");
    }

    public static Date valueof(String date, String format) {
        return parse(date, format);
    }

    public static Date valueOfStandard(String date) {
        return parse(date, "yyyy-MM-dd");
    }

    public static Date valueOfShort(String date) {
        return parse(date, "yyyyMMdd");
    }

    public static Date valueOfAll(String date) {
        return parse(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static boolean isSameDay(Date d1, Date d2) {
        return roundToDay(d1).getTime() == roundToDay(d2).getTime();
    }

    public static boolean compareDay(Date d1, Date d2) {
        return DateUtil.roundToDay(d1).before(DateUtil.roundToDay(d2));
    }

    public static boolean compareDate(Date d1, Date d2) {
        return d1.before(d2);
    }

    public static double dayInterval(Date big, Date small) {
        big = roundToDay(big);
        small = roundToDay(small);
        return (big.getTime() - small.getTime()) / (1000 * 60 * 60 * 24);
    }

    public static int getDiffDaysWithWeekend(Date start, Date end) {
        Date startDate = valueof(format(start, "yyyy-MM-dd"), "yyyy-MM-dd");
        Date endDate = valueof(format(end, "yyyy-MM-dd"), "yyyy-MM-dd");
        int result = 0;
        while (startDate.compareTo(endDate) <= 0) {
            if (startDate.getDay() != 6 && startDate.getDay() != 0) {
                result++;
            }
            startDate.setDate(startDate.getDate() + 1);
        }

        return result;
        // int rtn = getDiffDaysNoWeekend(start, end);
        // System.out.println(rtn);
        // System.out.println(rtn != Integer.MIN_VALUE);
        // return rtn != Integer.MIN_VALUE ? rtn + 1 : Integer.MIN_VALUE;
    }

    private static int getDiffDaysNoWeekend(Date start, Date end) {
        int rtn = Integer.MIN_VALUE;

        // Total days
        int days = getDiffDays(start, end);

        // Monday 1 -- Sunday 7
        int weekStart = getWeek(start);

        // Week count
        int intg = days / 7;

        // left days
        int mod1 = days % 7;

        // left days modified
        int mod2 = (weekStart + mod1) % 7;

        int factor = 0;
        if (mod1 != 0 && mod2 < weekStart) {

            // Start date is from Monday 1 -- Saturday 6.
            if (weekStart != 7) {
                factor = mod2 + 1;
                // Max value is 2
                if (factor > 2) {
                    factor = 2;
                }
            } else {
                factor = 1;
            }
        }
        rtn = days - intg * 2 - factor;
        return rtn;
    }

    private static int getDiffDays(Date start, Date end) {
        int rtn = Integer.MIN_VALUE;
        if (start != null && end != null) {
            long lngMinMilSec = start.getTime();
            long lngMaxMilSec = end.getTime();
            rtn = (int)((lngMaxMilSec - lngMinMilSec) / (1000 * 60 * 60 * 24));
        }
        return rtn;
    }

    private static int getWeek(Date dt) {
        int rtn = Integer.MIN_VALUE;
        Calendar cd = Calendar.getInstance();
        cd.setTime(dt);
        int week = cd.get(Calendar.DAY_OF_WEEK);
        if (week == 1) {
            rtn = 7;
        } else {
            rtn = week - 1;
        }
        return rtn;
    }

    public static double minuteInterval(Date big, Date small) {
        return (big.getTime() - small.getTime()) / (1000 * 60);
    }

    public static double secondInterval(Date big, Date small) {
        return (big.getTime() - small.getTime()) / 1000;
    }

    public static int workDayInterval(Date big, Date small) {
        big = roundToDay(big);
        small = roundToDay(small);

        GregorianCalendar smallGc = new GregorianCalendar();
        smallGc.setTime(small);

        GregorianCalendar bigGc = new GregorianCalendar();
        bigGc.setTime(big);

        int workDays = 0;
        long bigTime = bigGc.getTime().getTime();
        while (smallGc.getTime().getTime() < bigTime) {
            int week = smallGc.get(Calendar.DAY_OF_WEEK);
            smallGc.add(Calendar.DATE, 1);
            if (week == Calendar.SATURDAY || week == Calendar.SUNDAY) {
                continue;
            } else {
                workDays++;
            }
        }
        return workDays;
    }

    public static boolean isWorkDay(Date date) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        int week = gc.get(Calendar.DAY_OF_WEEK);
        if (week == Calendar.SATURDAY || week == Calendar.SUNDAY) {
            return true;
        }
        return false;
    }

    public static Date nextDate(Date date) {
        return roundToDay(add(date, Calendar.DATE, 1));
    }

    public static Date nextHour(Date date) {
        return roundToHour(add(date, Calendar.HOUR, 1));
    }

    public static Date nextNumberDate(Date date, int n) {
        n = n < 0 ? +n : n;
        return add(date, Calendar.DATE, n);
    }

    public static Date nextNumberYear(Date date, int n) {
        n = n < 0 ? +n : n;
        return roundToDay(add(date, Calendar.YEAR, n));
    }

    public static Date previousDate(Date date) {
        return roundToDay(add(date, Calendar.DATE, -1));
    }

    public static Date previousHour(Date date) {
        return roundToHour(add(date, Calendar.HOUR, -1));
    }

    public static Date previousNumberDate(Date date, int n) {
        n = n > 0 ? -n : n;
        return add(date, Calendar.DATE, n);
    }

    public static Date previousNumberYear(Date date, int n) {
        n = n > 0 ? -n : n;
        return roundToDay(add(date, Calendar.YEAR, n));
    }

    public static Date getFirstDayOfMonth(Date date) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.set(Calendar.DATE, 1);
        return roundToDay(gc.getTime());

    }

    public static Date getLastDayOfMonth(Date date) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(Calendar.MONTH, 1);
        gc.set(Calendar.DATE, 0);
        return roundToDay(gc.getTime());
    }

    public static Date getFirstDayOfMonthByNum(Date date, int num) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(Calendar.MONTH, num);
        gc.set(Calendar.DATE, 1);
        return roundToDay(gc.getTime());
    }

    public static Date getFirstDayOfWeek(Date date) {
        return DateUtil.previousNumberDate(date, DateUtil.getTimeField(date, Calendar.DAY_OF_WEEK) - Calendar.MONDAY);
    }

    public static Date getLastDayOfWeek(Date date) {
        return DateUtil.nextNumberDate(date, DateUtil.getTimeField(date, Calendar.DAY_OF_WEEK) - Calendar.SUNDAY);
    }

    public static String oracleToDate(Date date) {
        return "to_date('" + DateUtil.format(date, "yyyy-MM-dd") + "', 'yyyy-mm-dd')";
    }

    public static String getChineseWeekName(Date date) {
        int w = DateUtil.getTimeField(date, Calendar.DAY_OF_WEEK);
        String cw = "";
        switch (w) {
            case Calendar.SUNDAY:
                cw = "星期日";
                break;
            case Calendar.MONDAY:
                cw = "星期一";
                break;
            case Calendar.TUESDAY:
                cw = "星期二";
                break;
            case Calendar.WEDNESDAY:
                cw = "星期三";
                break;
            case Calendar.THURSDAY:
                cw = "星期四";
                break;
            case Calendar.FRIDAY:
                cw = "星期五";
                break;
            case Calendar.SATURDAY:
                cw = "星期六";
                break;
            default:
                break;
        }
        return cw;
    }

    public static Date setTimeOfDay(Date date, int hour, int minute, int second) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.set(Calendar.HOUR_OF_DAY, hour);
        gc.set(Calendar.MINUTE, minute);
        gc.set(Calendar.SECOND, second);
        gc.set(Calendar.MILLISECOND, 0);
        return gc.getTime();
    }

    public static List<Date> listMonthOption(Date startDate, Date endDate) {
        List<Date> list = new ArrayList<Date>();
        Date date = endDate;
        while (date.getTime() - startDate.getTime() > 0) {
            list.add(date);
            date = add(date, Calendar.MONTH, -1);
        }
        return list;
    }

    public static List<Date> listMonthOption(Date startDate, Date endDate, boolean isMonthStart) {
        List<Date> list = new ArrayList<Date>();
        Date date = null;
        if (isMonthStart) {
            date = getFirstDayOfMonth(startDate);
        } else {
            date = getLastDayOfMonth(startDate);
        }
        list.add(date);
        while (date.getTime() < endDate.getTime()) {
            date = add(date, Calendar.MONTH, 1);
            if (isMonthStart) {
                date = getFirstDayOfMonth(date);
            } else {
                date = getLastDayOfMonth(date);
            }
            list.add(date);
        }
        return list;
    }

    public static List<Date> listMonthOption(int n) {
        n = n < 0 ? +n : n;
        Date startDate = new Date();
        Date endDate = add(startDate, Calendar.MONTH, n);
        return listMonthOption(startDate, endDate);
    }

    public static List<Date> listQuarterOption(Date startDate, Date endDate, boolean isQuarterStart) {
        List<Date> list = listMonthOption(startDate, endDate);
        list.add(startDate);
        Set<Date> set = new TreeSet<Date>();
        for (Date date : list) {
            if (isQuarterStart) {
                set.add(getFirstDayOfQuarter(date));
            } else {
                set.add(getLastDayOfQuarter(date));
            }
        }
        return new ArrayList<Date>(set);
    }

    public static Date getFirstDayOfQuarter(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int month = getQuarterInMonth(Integer.valueOf(toMonth(date)), true);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        return calendar.getTime();
    }

    public static Date getLastDayOfQuarter(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int month = getQuarterInMonth(Integer.valueOf(toMonth(date)), false);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return calendar.getTime();
    }

    private static int getQuarterInMonth(int month, boolean isQuarterStart) {
        int months[] = null;
        if (isQuarterStart) {
            months = new int[] {1, 4, 7, 10};
        } else {
            months = new int[] {3, 6, 9, 12};
        }
        if (month >= 1 && month <= 3) {
            return months[0];
        } else if (month >= 4 && month <= 6) {
            return months[1];
        } else if (month >= 7 && month <= 9) {
            return months[2];
        } else if (month >= 10 && month <= 12) {
            return months[3];
        } else {
            return 0;
        }
    }

    /**
     * 
     * @Title: dateUtilAddMonth
     * @Description: 时增加month月
     * @param date
     *            开始时间
     * @param month
     *            要增加时间（月）
     * @return
     * @return: Date
     * @author: yangyuan
     * @date: 2016年12月19日 下午7:32:50
     */
    public static Date dateUtilAddMonth(Date date, Integer month) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        // 增加月份
        cd.add(Calendar.MONTH, month);
        return cd.getTime();
    }

    /**
     * 
     * @Title: dateUtilAdd
     * @Description: 开始时间加一天
     * @param startDate
     *            开始时间
     * @return
     * @return: Date 开始加一天的时间
     * @author: yangyuan
     * @date: 2016年12月19日 下午7:23:03
     */
    public static Date dateUtilAddDay(Date startDate) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(startDate);
        // 增加一天
        cd.add(Calendar.DATE, 1);
        return cd.getTime();
    }

    /**
     * 
     * @Title: dateUtilAdd
     * @Description: 开始时间减dayNum 天
     * @param startDate
     *            开始时间
     * @return
     * @return: Date
     * @author: yangyuan
     * @date: 2016年12月19日 下午7:23:03
     */
    public static Date dateUtilReduceDay(Date startDate, Integer dayNum) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(startDate);
        // 减dayNum天
        cd.add(Calendar.DATE, -dayNum);
        return cd.getTime();
    }

    public static String getTime() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(now);
    }

}
