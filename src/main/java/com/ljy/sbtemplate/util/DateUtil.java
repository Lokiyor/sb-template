package com.ljy.sbtemplate.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Lokiy
 * @date 2018/6/7
 * @description jre8日期帮助类
 * 需要其他的方法自行添加
 */
public class DateUtil {

    private static final Logger log = LogManager.getLogger();

    /**
     * 秒
     */
    public static final long SECOND_MILLI = 1000;

    /**
     * 分
     */
    public static final long MINUTE_MILLI = 60 * 1000;

    /**
     * 时
     */
    public static final long HOUR_MILLI = 60 * 60 * 1000;

    /**
     * 天
     */
    public static final long DAY_MILLI = 24 * 60 * 60 * 1000;

    /**
     * 东八区
     */
    private static final String ZONE_8 = "+8";

    /**
     * 获取当前时间
     * @return  当前时间
     */
    public static LocalDateTime localDateTime(){
        return LocalDateTime.now();
    }

    /**
     * 当前时间 date 类型
     * @return date类型
     */
    public static Date date(){
        return new Date();
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime){
        return Date.from(localDateTime
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static LocalDateTime date2LocalDateTime(Date date){
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    // 01. java.util.Date --> java.time.LocalDateTime
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    // 02. java.util.Date --> java.time.LocalDate
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    // 03. java.util.Date --> java.time.LocalTime
    public static LocalTime dateToLocalTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalTime();
    }


    // 04. java.time.LocalDateTime --> java.util.Date
    public static Date LocalDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }


    // 05. java.time.LocalDate --> java.util.Date
    public static Date LocalDateToDate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    // 06. java.time.LocalTime --> java.util.Date
    public static Date LocalTimeToDate(LocalDate localDate,LocalTime localTime) {
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static int year(Date date){
        return date.getYear() + 1900;
    }

    public static int month(Date date){
        return date.getMonth() + 1;
    }

    public static int day(Date date){
        return date.getDate();
    }


    /**
     * 获取当前时间戳
     * @return  时间戳
     */
    public static long timeStamp(){
        return Instant.now().getEpochSecond();
    }


    /**
     * 获取相应时间的时间戳
     * @param localDateTime 时间
     * @return  毫秒级时间戳
     */
    public static long timeStamp(LocalDateTime localDateTime){
        return localDateTime.toInstant(ZoneOffset.of(ZONE_8)).toEpochMilli();
    }



    public static void main(String[] args) {
//        System.out.println(timeStamp(LocalDateTime.now()));
        LocalDate date = dateToLocalDate(new Date());
        System.out.println(date);
        LocalDate localDate = date.plusMonths(-1);
//        System.out.println(localDate);
//        LocalDate date1 = LocalDate.of(2018,10,12);
//        int days = date1.until(date).getDays();
//        System.out.println(days);
        LocalDate of = LocalDate.of(localDate.getYear(), localDate.getMonth().getValue(), 15);
        System.out.println(localDate.isBefore(LocalDate.of(localDate.getYear(),localDate.getMonth().getValue(),15)));
    }

    /**
     * ijoke 2018-10-29
     * 获取传入日期的下月1号
     * @param date
     * @return
     */
    public static Date firstDayOfNextMonth(Date date) {
        //获得入参的日期
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        //获取下个月第一天：
        cd.add(Calendar.MONTH, 1);
        //设置为1号,当前日期既为次月第一天
        cd.set(Calendar.DAY_OF_MONTH,1);
        return cd.getTime();
    }

    /**
     * ijoke 2018-10-29
     * 根据传入的日期和int数字，对月份做加减操作，正数为往后推算月份，负数往前推算月份
     * 可跨年
     * @param inDate 传入的日期
     * @param num 需要增加的月数
     * @return
     */
    public static Date getMonthAdd(Date inDate,int num){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(inDate);
        rightNow.add(Calendar.MONTH,num);//日期加3个月
        Date outDate=rightNow.getTime();
        return outDate;
    }

    /**
     * 判断是否是当月最后一天
     * @param date
     * @return
     */
    public static boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH) == calendar
                .getActualMaximum(Calendar.DAY_OF_MONTH);
    }


}
