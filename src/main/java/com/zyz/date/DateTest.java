package com.zyz.date;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: YunzhenZhang
 * @Description:
 *         时间测试类
 * @Date: Created in 17:58 2018/4/30
 */
public class DateTest {

    /**
     * 根据毫秒数转化为日期类型
     */
    @Test
    public void test(){
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        // 或者
        /*Date date1 = new Date();
        date1.setTime(l);
        System.out.println(date1);*/
        System.out.println(date);
    }

    /**
     * 日期转毫秒
     */
    @Test
    public void test2(){
        Date date = new Date();
        System.out.println(date.getTime());
    }

    /**
     * 比较date大小
     */
    @Test
    public void test3() throws InterruptedException {
        Date date = new Date();
        Thread.sleep(100L);
        Date date1 = new Date();
        System.out.println(date1.after(date));
    }

    /**
     * 判断两日期是否相等
     *          相等，返回0
     *          小于该日期，返回小于0的值
     *          大于该日期，返回大于0的zhi
     * @throws InterruptedException
     */
    @Test
    public void test4() throws InterruptedException {
        Date date = new Date();
        Thread.sleep(100L);
        Date date1 = new Date();
        System.out.println(date.compareTo(date1));
    }

    /**
     * 格式化日期格式
     */
    @Test
    public void test5(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");
        System.out.println(simpleDateFormat.format(date));
        System.out.println(simpleDateFormat1.format(date));
    }

    /**
     * String字符串转化为日期类型
     */
    @Test
    public void test6() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date parse = simpleDateFormat.parse("2017-9-11");
        System.out.println(parse);
    }

}
