package com.zyz.algorithm.test;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2022/04/07
 */
public class Thread1 implements Runnable{
    @Override
    public void run() {
        System.out.println("线程1");
    }

    public static void main(String[] args) {
        System.out.println("线程2");
        Thread1 thread1 = new Thread1();
        Thread thread = new Thread(thread1);
        thread.start();
    }
}
