/*
 * 文件名：DefaultMethodInterf.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zyz
 * 修改时间：2017年12月19日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.zyz.java8Demo;


/**
 *  接口的默认方法
 *  函数式接口（只有一个方法（默认方法 静态方法不包括））
 * @author zhangyunzhen
 * @version 2017年12月19日
 * @see DefaultMethodInterf
 * @since
 */
@FunctionalInterface
public interface DefaultMethodInterf {

    void test();


    /**
     *  静态方法（接口可以写实现）
     */
    static void test1(){
        System.out.println("我是静态方法");
    }

    /**
     * Description: <br>
     *  默认方法
     *
     * @param name
     * @see
     */
    default void defaultMethod(String name){
        System.out.println("我是默认方法"+name);
    }

    default void defaultMetho1(String name){
        System.out.println("我是默认方法"+name);
    }
        
}
