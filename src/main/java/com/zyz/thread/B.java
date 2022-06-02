package com.zyz.thread;

import sun.applet.Main;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 11:18 2018/7/15
 */
public class B extends A {

    @Override
    public void a() {
        System.out.println("B");
    }


    public static void main(String[] args) {
        A a = new B();
        a.a();
    }
}
