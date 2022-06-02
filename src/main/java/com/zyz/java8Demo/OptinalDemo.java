package com.zyz.java8Demo;

import org.junit.Test;

import java.util.Optional;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 11:17 2018/9/7
 */
public class OptinalDemo {


    @Test
    public void test() {
        String s = Optional.of("aasd").map(p -> p.replaceAll("a", "d")).orElse("11111");
        System.out.println(s);
    }

    @Test
    public void test1() {
        // 如果不为null,则做一些事情
      Optional.of("aaa").ifPresent(p -> System.out.println("a"));
      Optional.ofNullable(null).ifPresent(p -> System.out.println("aa"));
    }
}
