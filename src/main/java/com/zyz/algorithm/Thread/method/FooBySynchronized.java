package com.zyz.algorithm.Thread.method;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/11/14
 */
public class FooBySynchronized {


    private Object lock;

    private int flag = 1;


    public FooBySynchronized() {
        lock = new Object();
    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (lock) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            while (flag != 1) lock.wait();
            printFirst.run();
            flag = 2;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (flag != 2) lock.wait();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag = 3;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (flag != 3) lock.wait();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            flag = 1;
            lock.notifyAll();
        }
    }
}
