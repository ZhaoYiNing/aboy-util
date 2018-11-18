package org.aboy.util;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Date;

/**
 * @Title: DateUtil
 * @Description: 时间处理工具类
 * @author: zhaoyining1113@126.com
 * @date 2018/11/18 15:23
 * @since JDK 1.8
 */
public class LocalDateUtil {

  public static final DateTimeFormatter DATETIME_FORMATTER =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


  /**
   * 获取当前日期
   * @return 2018-11-18 10:10:10
   */
  public static String getNowDateTime() {
    return LocalDateTime.now().format(DATETIME_FORMATTER);
  }

  /**
   * 根据输入类型进行转换
   * @return 根据输入类型进行转换时间字符串
   */
  public static String getNowFormatStr(DateTimeFormatter formatter) {
    return LocalDateTime.now().format(formatter);
  }

  /**
   * 获取当前时间字符串
   * @param pattern 格式，ex. yyyyMMddHHmmss
   * @return 当前时间格式字符串
   */
  public static String getNowFormatStr(String pattern) {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
  }

  /**
   * 获取当前日期
   * @param date 时间
   * @return 2018-11-18 10:10:10
   */
  public static String getNowDateTime(Date date) {
    return dateToLocalDateTime(date).format(DATETIME_FORMATTER);
  }

  /**
   * 根据输入类型进行转换
   * @param date 时间
   * @return 根据输入类型进行转换时间字符串
   */
  public static String getNowFormatStr(Date date ,DateTimeFormatter formatter) {
    return dateToLocalDateTime(date).format(formatter);
  }

  /**
   * 获取当前时间字符串
   * @param date 时间
   * @param pattern 格式，ex. yyyyMMddHHmmss
   * @return 当前时间格式字符串
   */
  public static String getNowFormatStr(Date date ,String pattern) {
    return dateToLocalDateTime(date).format(DateTimeFormatter.ofPattern(pattern));
  }


  /**
   * 日期相隔天数，如果结束时间大于开始时间，则交换
   * @param start 开始日期
   * @param end 结束日期
   * @return 相隔天数
   */
  public static int betweenDays(Date start, Date end) {
    return betweenDays(dateToLocalDate(start), dateToLocalDate(end));
  }

  /**
   * 日期相隔天数，如果结束时间大于开始时间，则交换
   * @param start 开始日期
   * @param end 结束日期
   * @return 相隔天数
   */
  public static int betweenDays(LocalDate start, LocalDate end) {
    return Math.abs(Period.between(start, end).getDays());
  }

  /**
   * 日期相隔小时，如果结束时间大于开始时间，则交换
   * @param start 开始日期
   * @param end 结束日期
   * @return 相隔小时
   */
  public static long betweenHours(Date start, Date end) {
    return betweenHours(dateToLocalDateTime(start), dateToLocalDateTime(end));
  }

  /**
   * 日期相隔小时，如果结束时间大于开始时间，则交换
   * @param start 开始日期
   * @param end 结束日期
   * @return 相隔小时
   */
  public static long betweenHours(Temporal start, Temporal end) {
    return Math.abs(Duration.between(start, end).toHours());
  }

  /**
   * 日期相隔分钟，如果结束时间大于开始时间，则交换
   * @param start 开始日期
   * @param end 结束日期
   * @return 日期相隔分钟
   */
  public static long betweenMinutes(Date start, Date end) {
    return betweenMinutes(dateToLocalDateTime(start), dateToLocalDateTime(end));
  }

  /**
   * 日期相隔分钟，如果结束时间大于开始时间，则交换
   * @param start 开始日期
   * @param end 结束日期
   * @return 日期相隔分钟
   */
  public static long betweenMinutes(Temporal start, Temporal end) {
    return Math.abs(Duration.between(start, end).toMinutes());
  }

  /**
   * 日期相隔毫秒数，如果结束时间大于开始时间，则交换
   * @param start 开始日期
   * @param end 结束日期
   * @return 日期相隔毫秒数
   */
  public static long betweenMillis(Date start, Date end) {
    return betweenMillis(dateToLocalDateTime(start) , dateToLocalDateTime(end));
  }

  /**
   * 日期相隔毫秒数
   * @param start 开始日期
   * @param end 结束日期
   * @return 日期相隔毫秒数
   */
  public static long betweenMillis(Temporal start, Temporal end) {
    return Math.abs(Duration.between(start, end).toMillis());
  }

  /**
   * 判断是否为当天
   * @param date 日期
   * @return true:是  false：否
   */
  public static boolean isToday(LocalDate date) {
    return LocalDate.now().equals(date);
  }

  /**
   * 获取自1970-01-01T00：00：00Z时代以来的毫秒数
   * @param dateTime 时间参数
   * @return 自1970-01-01T00：00：00Z时代以来的毫秒数
   */
  public static long toEpochMilli(LocalDateTime dateTime) {
    return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
  }

  /**
   * date 转换为 LocalDate
   * @param date java.util.Date
   * @return LocalDate
   */
  public static LocalDate dateToLocalDate(Date date){
    Instant instant = date.toInstant();
    ZoneId zoneId = ZoneId.systemDefault();
    return instant.atZone(zoneId).toLocalDate();
  }

  /**
   * date 转换为 LocalDateTime
   * @param date java.util.Date
   * @return LocalDateTime
   */
  public static LocalDateTime dateToLocalDateTime(Date date){
    Instant instant = date.toInstant();
    ZoneId zoneId = ZoneId.systemDefault();
    return instant.atZone(zoneId).toLocalDateTime();
  }

  /**
   * date 转换为 LocalTime
   * @param date java.util.Date
   * @return LocalTime
   */
  public static LocalTime dateToLocalTime(Date date){
    Instant instant = date.toInstant();
    ZoneId zoneId = ZoneId.systemDefault();
    return instant.atZone(zoneId).toLocalTime();
  }

  /**
   * LocalDate 转为 date
   * @param localDate java.time.LocalDate
   * @return java.util.Date
   */
  public static Date localDateToDate(LocalDate localDate){
    ZoneId zone = ZoneId.systemDefault();
    Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
    return Date.from(instant);
  }

  /**
   * LocalDateTime 转为 date
   * @param localDateTime java.time.LocalDateTime
   * @return java.util.Date
   */
  public static Date localDateTimeToDate(LocalDateTime localDateTime){
    ZoneId zone = ZoneId.systemDefault();
    Instant instant = localDateTime.atZone(zone).toInstant();
    return Date.from(instant);
  }

  /**
   * 获取当天的最后一秒
   * @param date 时间
   * @return yyyy-MM-dd 23:59:59
   */
  public static Date getEndOfDay(Date date){
    return localDateTimeToDate(dateToLocalDate(date).atTime(23,59,59));
  }

  /**
   * 获取当天的第一秒
   * @param date 时间
   * @return yyyy-MM-dd 00:00:00
   */
  public static Date getStartOfDay(Date date){
    return localDateTimeToDate(dateToLocalDate(date).atStartOfDay());
  }
}
