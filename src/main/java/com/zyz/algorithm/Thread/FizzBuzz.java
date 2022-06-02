package com.zyz.algorithm.Thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2022/04/14
 */
public class FizzBuzz {

    private int n;

    private Semaphore semaphore1;

    private Semaphore semaphore2;

    private Semaphore semaphore3;

    private Semaphore semaphore4;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // ---n---

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 0; i < n; i++) {

            printFizz.run();

        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {

    }

}
