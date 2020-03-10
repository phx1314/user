package com.example.user.core.utils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangtao
 * <p>
 * modify
 * @author krauser
 */
public abstract class DateUtils {

    public static final String SIMPLE_DATE_FORMAT = "yyyyMMdd";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_DATE_FORMAT_1 = "yyyy/MM/dd";
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_TIME_MILL_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DEFAULT_DATE_TIME_FORMAT_MINI = "yyyyMMddhhmmssSSS";
    public static final String DEFAULT_DATE_FORMAT_YYYY_MM = "yyyy-MM";
    public static final String DATE_FORMAT = "yyyy年-MM月-dd日";

    /**
     * 存放不同的日期模板格式的sdf的Map
     */
    private static ThreadLocal<Map<String, SimpleDateFormat>> sdfMap =
            new ThreadLocal<Map<String, SimpleDateFormat>>() {
                @Override
                protected Map<String, SimpleDateFormat> initialValue() {
                    return new HashMap<String, SimpleDateFormat>();
                }
            };

    /**
     * 返回一个SimpleDateFormat,每个线程只会new一次pattern对应的sdf
     *
     * @param pattern
     * @return
     */
    private static SimpleDateFormat getSdf(final String pattern) {
        Map<String, SimpleDateFormat> tl = sdfMap.get();
        SimpleDateFormat sdf = tl.get(pattern);
        if (sdf == null) {
            sdf = new SimpleDateFormat(pattern);
            tl.put(pattern, sdf);
        }
        return sdf;
    }

    /**
     * date -> str
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        return getSdf(pattern).format(date);
    }

    /**
     * str -> date
     *
     * @param dateStr
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date parse(String dateStr, String pattern) throws ParseException {
        return getSdf(pattern).parse(dateStr);
    }

    /**
     * 当前时间
     *
     * @return
     */
    public static Date now() {
        return new Date();
    }

    /**
     * 日期转换成默认的字符串（yyyy-MM-dd HH:mm:ss）
     *
     * @param date
     * @return
     */
    public static String dateToStr(Date date) {
        return dateToStr(date, DEFAULT_DATE_TIME_FORMAT);
    }

    /**
     * 日期转换成yyyyMMdd
     *
     * @param date
     * @return
     */
    public static String dateToyyyyMMdd(Date date) {
        return dateToStr(date, SIMPLE_DATE_FORMAT);
    }

    /**
     * 日期转换成指定格式的字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToStr(Date date, String pattern) {
        if (date == null || pattern == null) {
            return null;
        }
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 日期转换成默认的字符串（yyyy-MM-dd HH:mm:ss）
     *
     * @param dateStr
     * @return
     */
    public static Date strToDate(String dateStr) {
        return strToDate(dateStr, DEFAULT_DATE_TIME_FORMAT);
    }

    /**
     * 日期转换成指定格式的字符串
     *
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date strToDate(String dateStr, String pattern) {
        if (dateStr == null || pattern == null) {
            return null;
        }
        DateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }

    /**
     * 对日期 秒 加减
     *
     * @param d
     * @param amount
     * @return
     * @author wangtao
     * @version
     */
    public static Date addSecond(Date d, int amount) {
        return add(d, Calendar.SECOND, amount);
    }

    /**
     * 对日期 分钟 加减
     *
     * @param d
     * @param amount
     * @return
     * @author wangtao
     * @version
     */
    public static Date addMinute(Date d, int amount) {
        return add(d, Calendar.MINUTE, amount);
    }

    /**
     * 对日期 天 加减
     *
     * @param d
     * @param amount
     * @return
     * @author wangtao
     * @version
     */
    public static Date addDay(Date d, int amount) {
        return add(d, Calendar.DAY_OF_MONTH, amount);
    }

    /**
     * 对日期 月 加减
     *
     * @param d
     * @param amount
     * @return
     * @author wangtao
     * @version
     */
    public static Date addMonth(Date d, int amount) {
        return add(d, Calendar.MONTH, amount);
    }

    /**
     * 对日期 年 加减
     *
     * @param d
     * @param amount
     * @return
     * @author wangtao
     * @version
     */
    public static Date addYear(Date d, int amount) {
        return add(d, Calendar.YEAR, amount);
    }

    /**
     * 对日期 加减
     *
     * @param d
     * @param field
     * @param amount
     * @return
     * @author wangtao
     * @version
     */
    public static Date add(Date d, int field, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(field, amount);
        return c.getTime();
    }

    /**
     * 等同于Calendar.get(int arg)
     *
     * @param date
     * @param type
     * @return
     */
    public static int get(Date date, int type) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(type);
    }

    /**
     * 取年
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        return get(date, Calendar.YEAR);
    }

    /**
     * 取月
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        return get(date, Calendar.MONTH) + 1;// 月是从0开始 所有需要+1
    }

    /**
     * 取月中的某日
     *
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        return get(date, Calendar.DAY_OF_MONTH);
    }

    /**
     * 取年中的某日
     *
     * @param date
     * @return
     */
    public static int getDayOfYear(Date date) {
        return get(date, Calendar.DAY_OF_YEAR);
    }

    /**
     * 取月份
     *
     * @param date
     * @return
     */
    public static int getDayOfMonth(Date date) {
        return get(date, Calendar.DAY_OF_MONTH);
    }

    /**
     * 取星期几
     *
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date) {
        return get(date, Calendar.DAY_OF_WEEK);
    }

    /**
     * 根据日期取下月1号
     *
     * @param date
     * @return
     */
    public static Date nextMonthFirstDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 2日期相差的天数
     *
     * @param d1 前面日期
     * @param d2 后面的日期
     * @return
     */
    public static Integer daysBetween(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            return null;
        }

        d1 = strToDate(dateToStr(d1, DEFAULT_DATE_FORMAT), DEFAULT_DATE_FORMAT);
        d2 = strToDate(dateToStr(d2, DEFAULT_DATE_FORMAT), DEFAULT_DATE_FORMAT);
        long between_days = (d2.getTime() - d1.getTime()) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 获取店铺数值开始时间
     *
     * @param month
     * @return
     */
    public static Date getStartDate(Integer month) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.add(Calendar.SECOND, 1);
        return cal.getTime();
    }

    /**
     * 获取店铺数值的结束时间
     *
     * @return
     */
    public static Date getLastMonthEndData() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    public static Date getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static String getDateString(int month) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date time = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
        return sdf.format(time);
    }

    public static String getEndDateString(int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, month);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        Date time = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
        return sdf.format(time);
    }

    /**
     * 生成开始时间
     *
     * @param month
     * @return
     */
    public static Date generateFormatStartDate(int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, month);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 生成结束时间
     *
     * @return
     */
    public static Calendar generateFormatEndDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////

    public static Date getDayOffsetBegin(int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    /**
     * 日期转化成国际日期
     *
     * @param date
     * @return
     */
    public static XMLGregorianCalendar dateToXmlDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        DatatypeFactory dtf = null;
        try {
            dtf = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
        }
        XMLGregorianCalendar dateType = dtf.newXMLGregorianCalendar();
        dateType.setYear(cal.get(Calendar.YEAR));
        dateType.setMonth(cal.get(Calendar.MONTH) + 1);
        dateType.setDay(cal.get(Calendar.DAY_OF_MONTH));
        dateType.setHour(cal.get(Calendar.HOUR_OF_DAY));
        dateType.setMinute(cal.get(Calendar.MINUTE));
        dateType.setSecond(cal.get(Calendar.SECOND));
        return dateType;
    }

    /**
     * long类型的时间数字转换可读的时间
     *
     * @param time
     * @return
     */
    public static String getTime(long time) {
        String str = "";
        time = time / 1000;
        int s = (int) (time % 60);
        int m = (int) (time / 60 % 60);
        int h = (int) (time / 3600);
        str = h + "小时" + m + "分" + s + "秒";
        return str;
    }

    /**
     * 获取当月开始的第day天
     *
     * @param day
     * @return
     */
    public static Date getDayMonthOffsetBegin(int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.add(Calendar.DAY_OF_MONTH, day);
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取两个日期之间的月份
     *
     * @param minDate
     * @param maxDate
     * @return
     * @throws ParseException
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");// 格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }

        return result;
    }

    /**
     * 比较时间
     *
     * @param DATE1
     * @param DATE2
     * @return
     */
    public static int compareDate(String DATE1, String DATE2) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public static int compareDate(Date DATE1, Date DATE2) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DateUtils.format(DATE1, DateUtils.DEFAULT_DATE_FORMAT));
            Date dt2 = df.parse(DateUtils.format(DATE2, DateUtils.DEFAULT_DATE_FORMAT));
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public static int compareDateTime(String DATE1, String DATE2) {

        DateFormat df = new SimpleDateFormat(DateUtils.DEFAULT_DATE_TIME_FORMAT);
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public static int compareDateTime(Date dt1, Date dt2) {

        try {
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取指定日期所在月份开始的时间戳
     *
     * @param date 指定日期
     * @return
     */
    public static Date getMonthBegin(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        // 设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        // 将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        // 将分钟至0
        c.set(Calendar.MINUTE, 0);
        // 将秒至0
        c.set(Calendar.SECOND, 0);
        // 将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        // 获取本月第一天的时间戳
        return c.getTime();
    }

    /**
     * 获取指定日期所在月份开始的时间戳
     *
     * @param date 指定日期
     * @return
     */
    public static Date getWeekBegin(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        // 设置为周一, 1-周日，2-周一
        c.set(Calendar.DAY_OF_WEEK, 2);
        // 将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        // 将分钟至0
        c.set(Calendar.MINUTE, 0);
        // 将秒至0
        c.set(Calendar.SECOND, 0);
        // 将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        // 获取本月第一天的时间戳
        return c.getTime();
    }

    /**
     * 获取指定日期所在月份结束的时间戳
     *
     * @param date 指定日期
     * @return
     */
    public static Date getMonthEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // 设置为当月最后一天
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        // 将小时至23
        c.set(Calendar.HOUR_OF_DAY, 23);
        // 将分钟至59
        c.set(Calendar.MINUTE, 59);
        // 将秒至59
        c.set(Calendar.SECOND, 59);
        // 将毫秒至999
        c.set(Calendar.MILLISECOND, 999);
        // 获取本月最后一天的时间戳
        return c.getTime();
    }

    public static Date getCurrentDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(c.getTime());
        // 设置为当月最后一天
        // 将小时至00
        c.set(Calendar.HOUR_OF_DAY, 00);
        // 将分钟至00
        c.set(Calendar.MINUTE, 00);
        // 将秒至00
        c.set(Calendar.SECOND, 00);
        return c.getTime();
    }

    public static Date getDateStartTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // 设置为当月最后一天
        // 将小时至00
        c.set(Calendar.HOUR_OF_DAY, 00);
        // 将分钟至00
        c.set(Calendar.MINUTE, 00);
        // 将秒至00
        c.set(Calendar.SECOND, 00);
        return c.getTime();
    }

    public static void main(String[] args) {
        System.out.println(">>>" + DateUtils.getDayOfWeek(new Date()));
        System.out.println(">>>" + DateUtils.getDayOfMonth(new Date()));


        System.out.println(">>>" + DateUtils.getWeekBegin(new Date()));
        System.out.println(">>>" + DateUtils.getMonthBegin(new Date()));


    }
}