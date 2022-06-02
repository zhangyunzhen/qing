/*
 * 文件名：testApp.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zyz
 * 修改时间：2017年7月16日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.zyz.paramTransmit;


import org.junit.Test;


/**
 *  java参数传递
 *      参数传递方式有两种。一种是值传递，另一种是引用传递
 *      java参数传值为值传递
 * @author zhangyunzhen
 * @version 2017年7月16日
 * @see testApp
 * @since
 */
public class testApp {

    public static void test(int a) {
        a += 3;
    }

    public static void test(TestBean bean) {
        bean.setAa("传参后");
    }
    
    @Test
    public void test1() {
        int a = 3;
        test(a);
        System.out.println(a);
    }
    
    @Test
    public void test2(){
        TestBean bean = new TestBean();
        bean.setAa("传参前");
        test(bean);
        System.out.println(bean.getAa());
        
    }

}
