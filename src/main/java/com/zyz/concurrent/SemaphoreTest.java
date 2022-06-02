package com.zyz.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/06/23
 */
public class SemaphoreTest {


    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        System.out.println(semaphore.tryAcquire());
        semaphore.release();
        System.out.println(semaphore.tryAcquire());
        System.out.println(semaphore.tryAcquire());

        System.out.println("你好");
        //semaphore.acquire(2);
        //semaphore.release(2);

/*
        System.out.println("你好" + semaphore.tryAcquire());
        semaphore.release();
        semaphore.release();
        System.out.println("你好" + semaphore.tryAcquire());
        System.out.println("你好" + semaphore.tryAcquire());

*/

       // Thread.currentThread().interrupt();
      //  LockSupport.park();
       // System.out.println("你好"+Thread.currentThread().isInterrupted());
    }
}
