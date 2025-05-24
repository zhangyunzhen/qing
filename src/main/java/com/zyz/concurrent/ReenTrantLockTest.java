package com.zyz.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/06/20
 */
public class ReenTrantLockTest {

    private static Lock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();


    public static void main(String[] args) {
        sync("你好");



    }

    public static void sync(String desc) {
        lock.lock();
        try {
            new Thread(() -> {
                lock.lock();
            }).start();

            Thread.sleep(1000000);

            condition.await();
            System.out.println(desc);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
