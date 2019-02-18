package com.ljy.sbtemplate.util;


import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Lokiy
 * @date 2018/6/7
 * @description 时间计算帮助类
 * 需要的方法自行添加
 */
public class CalendarUtil {


    public static Calendar buildCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date buildDate(int year, int month, int day) {
        return new Date(year-1900, month-1, day);
    }

    /**
     * 获取的年份
     * @param localDateTime 传入的时间
     * @return  返回年份
     */
    public static int year(LocalDateTime localDateTime){
        return localDateTime.getYear();
    }

    /**
     * 获取月份
     * @param localDateTime 传入的时间
     * @return  返回月份
     */
    public static int month(LocalDateTime localDateTime){
        return localDateTime.getMonth().getValue();
    }

    /**
     * 获取日期
     * @param localDateTime 传入的时间
     * @return  返回当月日期
     */
    public static int day(LocalDateTime localDateTime){
        return localDateTime.getDayOfMonth();
    }


    /**
     * 向前 向后 取天数
     * @param date
     * @param days
     * @return
     */
    public static Date plusDays(Date date, long days) {
        return DateUtil.localDateTime2Date(
                DateUtil.date2LocalDateTime(date).plusDays(days)
        );
    }

    /**
     * 向前 向后 月份
     * @param date
     * @param months
     * @return
     */
    public static Date plusMonth(Date date, long months) {
        return DateUtil.localDateTime2Date(
                DateUtil.date2LocalDateTime(date).plusMonths(months)
        );
    }

    /**
     * 获取最后一天
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDateInMonth(int year, int month) {
        Date date = buildDate(year, month, 1);
        return getLastDateInMonth(date);
    }



    /**
     * 获取最后一天
     * @param date
     * @return
     */
    public static Date getLastDateInMonth(Date date) {
        Calendar calendar = buildCalendar(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }


    /**
     * 判断传入之日是否为月末日
     * @param date
     * @return
     */
    public static boolean isLastDateInMonth(Date date){
        Date lastDateInMonth = getLastDateInMonth(date);
        return lastDateInMonth.getDate() == date.getDate();

    }

    /**
     * 下个月
     * @param date
     * @return
     */
    public static Date getNextMonth(Date date) {
        Calendar calendar = buildCalendar(date);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 上个月
     * @param date
     * @return
     */
    public static Date getPrevMonth(Date date) {
        Calendar calendar = buildCalendar(date);
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        String re = "太屋中国/资讯科技中心/后端技术部";
        System.out.println(re.substring(re.lastIndexOf("/")+1, re.length()));
    }
}
