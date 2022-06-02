package com.zyz.date;

import org.junit.Test;

import javax.swing.text.DateFormatter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 0:13 2018/5/1
 */
public class Java8Time {


    /**
     * 获取当前日期 时间
     */
    @Test
    public void test1(){
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalTime now1 = LocalTime.now();
        System.out.println(now1);
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);
    }

    /**
     * 使用特定的格式将localDate转化为字符串
     */
    @Test
    public void test2(){
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        System.out.println(format);
    }

    /**
     * 将字符串转化为LocalDate
     */
    @Test
    public void test3(){
        String date = "2019:08:09";
        LocalDate parse = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        System.out.println(parse);
    }
}
