package com.zyz.algorithm.Thread.method;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * This is Description
 *
 *      多个线程有序执行，循环多次
 *      使用CountDownLatch要在方法内部保证多个方法有序，外部保证每次循环有序
 *
 * @author yunzhen.zhang
 * @date 2021/11/30
 */
public class FooByCountDownLatch {

    private CountDownLatch countDownLatch;
    private CountDownLatch countDownLatch2;
    private CountDownLatch countDownLatch3;


    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                Semaphore semaphore = new Semaphore(0);
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println("aaa");
    }


    public FooByCountDownLatch() {
        countDownLatch = new CountDownLatch(0);
        countDownLatch2 = new CountDownLatch(1);
        countDownLatch3 = new CountDownLatch(1);
    }


    public void first(Runnable printFirst) throws InterruptedException {
        countDownLatch.await();
        printFirst.run();
        countDownLatch2.countDown();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatch2.await();
        printSecond.run();
        countDownLatch3.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch3.await();
        printThird.run();
        countDownLatch.countDown();
    }
}
