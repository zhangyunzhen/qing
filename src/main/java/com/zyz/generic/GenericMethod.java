/*
 * 文件名：GenericMethod.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zyz
 * 修改时间：2018年1月15日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.zyz.generic;

/**
 * 泛型方法的使用
 *      优势：有类型参数推断
 * @author zhangyunzhen
 * @version 2018年1月15日
 * @see GenericMethod
 * @since
 */
public class GenericMethod {

    public <T> T f(T t){
        System.out.println(t.getClass().getName());
        return t;
    }
    
    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        gm.f("aa");
        gm.f(1L);
        gm.f(true);
    }
}
