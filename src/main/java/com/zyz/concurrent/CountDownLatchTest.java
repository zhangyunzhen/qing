package com.zyz.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 14:34 2018/12/12
 */
public class CountDownLatchTest {


    public void countDownLatchtest() throws InterruptedException {
        System.out.println("方法开始了"+Thread.currentThread().getName());
        System.out.println("====");
        Thread.sleep(3000);
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
        //两个线程之间相互独立
        new Thread(() -> {
            try {
                countDownLatchTest.countDownLatchtest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }).start();
        new Thread(() -> {
            try {
                countDownLatchTest.countDownLatchtest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        }).start();
        // 查过过期时间如果其他线程还没有会执行完毕的话  返回false
        boolean await = countDownLatch.await(6000, TimeUnit.MILLISECONDS);
        //  等所有的线程执行完主线程后面的代码才能执行
        System.out.println("线程都跑完了" + await);

    }

}
