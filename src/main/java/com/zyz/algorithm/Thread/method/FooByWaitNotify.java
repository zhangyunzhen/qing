package com.zyz.algorithm.Thread.method;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/11/30
 */
public class FooByWaitNotify {


    private Object lock1;

    private Object lock2;

    private Object lock3;

    public FooByWaitNotify() {
        lock1 = new Object();
        lock2 = new Object();
        lock3 = new Object();
    }


    public void firstPrint(Runnable runnable) throws Exception {
        synchronized (lock1) {
            lock2.wait();
            runnable.run();
            lock2.notifyAll();
        }
    }

    public void secondaryPrint(Runnable runable) throws Exception {
        synchronized (lock2) {
            lock3.wait();
            runable.run();
            lock3.notifyAll();
        }
    }

    public void thirdPrint(Runnable runable) {

    }

    public static void main(String[] args) {
       // Thread.sleep();

    }
}
