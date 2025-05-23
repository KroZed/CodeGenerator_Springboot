package com.prj.util;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
public class LocalDateUtil {
    public static LocalDate fromString(String str)
    {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(str,df);
    }
    public static LocalDate fromTimestamp(long timestamp)
    {
        LocalDate d = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault()).toLocalDate();
        return d;
    }
    public static LocalDate fromDate(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
    }
    public static Date toDate(LocalDate date) {
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    public static Long getMillisecond(LocalDate date) {
        return date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
    public static Long getSeconds(LocalDate date) {
        return date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }
    public static String formatTime(LocalDate date,String pattern) {
        pattern = pattern == null ? "yyyy-MM-dd" : pattern;
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
    public static String formatNow(String pattern) {
        return  formatTime(LocalDate.now(), pattern);
    }
    public static LocalDate plus(LocalDate date, long number, TemporalUnit field) {
        return date.plus(number, field);
    }
    public static LocalDate minus(LocalDate date, long number, TemporalUnit field){
        return date.minus(number,field);
    }
    public static long betweenTwoTDate(LocalDate start, LocalDate end, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(start), LocalDate.from(end));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12 + period.getMonths();
        }
        return field.between(start, end);
    }
}
