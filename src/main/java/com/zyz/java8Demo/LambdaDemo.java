/*
 * 文件名：LambdaDemo.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zyz
 * 修改时间：2017年12月19日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.zyz.java8Demo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * Lambda表达式Demo
 * @author zhangyunzhen
 * @version 2017年12月19日
 * @see LambdaDemo
 * @since
 */
public class LambdaDemo {

    /**
     * Description: <br>
     *      接口的默认方法
     * @see
     */
    @Test
    public void testDefaultMeth(){
        DefaultMethodInterf inter = new DefauMethImp();
        inter.defaultMethod("hahha");
        inter.defaultMetho1("ccc");

        // 测试静态方法
        DefaultMethodInterf.test1();
    }

    /**
     *  方法引用
     *      需配合lamda表达式使用
     */
    @Test
    public void testMethodRef(){
        DefauMethImp inter = new DefauMethImp();

        // 构造器引用
        inter.methodRef(User::new);
        inter.methodRef(()->new User());

        // 静态方法引用
        // 需要注意： 静态方法的参数需要是User
        ArrayList<User> objects = Lists.newArrayList();
        objects.forEach(User::a);
        // 成员方法引用
        objects.forEach(User::b);

    }

    /** 
     *  函数式接口（只包含一个抽象方法 ）
     * @see
     */
    @Test
    public void testLambda(){
        Runnable runnable = ()->System.out.println("aa");
        new Thread(runnable).start();
    }
    
    
    public static void main(String[] args) {
       // Arrays.asList("aaa","bbb","ccc").forEach(e -> System.out.println(e+"函数式编程"));
        List<String> collect = Arrays.asList("aaa", "bbb", "ccc").stream().filter(p -> StringUtils.equalsIgnoreCase("aaa", p)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }
}
