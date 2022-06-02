package com.zyz.algorithm.Thread.method;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 交替打印
 *      核心思想：
 *          使用一个状态量定义执行顺序 和 使用线程阻塞唤醒机制
 *          线程阻塞唤醒机制保证线程能正常阻塞唤醒。 wait/notify,semaphore,locksupport,countdownLatch,ReentrantLock都可以实现这一点
 *
 *      题解：
 *          1.使用sychronized + wait/notify +状态变量
 *          2.使用信号量semaphore
 *          3.使用while+AtomicInteger
 *          4.使用LockSupport.park 和 LockSupport.unpark
 *          5.使用ReentrantLock+Condition
 *          6.使用countdownLatch
 *
 *  https://blog.csdn.net/wat1r/article/details/119054576
 *
 * @author yunzhen.zhang
 * @date 2021/11/14
 */
public class FooBySemaphore {

    private Semaphore semaphore;
    private Semaphore semaphore2;
    private Semaphore semaphore3;

    public FooBySemaphore() {
        AtomicInteger integer = new AtomicInteger();
        integer.incrementAndGet();
        semaphore = new Semaphore(0);
        semaphore2 = new Semaphore(0);
        semaphore3 = new Semaphore(1);
    }



    public void first(Runnable printFirst) throws InterruptedException {
        semaphore3.acquire();
        printFirst.run();
        semaphore.release(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore2.release(1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        semaphore3.release(1);
    }
}
