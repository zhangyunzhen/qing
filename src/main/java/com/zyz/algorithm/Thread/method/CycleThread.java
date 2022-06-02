package com.zyz.algorithm.Thread.method;

import com.zyz.algorithm.Thread.method.FooBySemaphore;

/**
 *  三个线程交替执行
 *
 * @author yunzhen.zhang
 * @date 2021/11/30
 */
public class CycleThread {


    public static void main(String[] args) {
        FooBySemaphore foo = new FooBySemaphore();


        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    foo.first(() -> {
                        System.out.println("1");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    foo.second(() -> {
                        System.out.println("2");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    foo.third(() -> {
                        System.out.println("3");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


}
