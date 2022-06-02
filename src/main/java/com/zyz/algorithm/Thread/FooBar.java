package com.zyz.algorithm.Thread;

import java.util.concurrent.Semaphore;

/**
 * This is Description
 *
 *      两个线程交替打印
 *
 * @author yunzhen.zhang
 * @date 2022/04/14
 */
public class FooBar {


    private Semaphore semaphore1;

    private Semaphore semaphore2;

    private int n;

    public FooBar(int n) {
        this.n = n;
        semaphore1 = new Semaphore(1);
        semaphore2 = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphore2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphore1.acquire();
        }
    }


}
