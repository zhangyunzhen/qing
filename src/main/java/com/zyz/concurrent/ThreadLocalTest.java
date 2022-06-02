package com.zyz.concurrent;

import org.junit.Test;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 21:40 2018/6/3
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();

    @Test
    public void test(){
        System.out.println(threadLocal.get());
    }

}
