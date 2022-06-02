package com.zyz.algorithm.lee;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/01/04
 */
public class B {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }


    public static void main(String[] args) {
        B b = new B();
        int n = b.findNthDigit(1000000000);
        System.out.println(n);
    }
}
