package com.zyz.concurrent;

/**
 * @Author: YunzhenZhang
 * @Description:
 *      volatile关键字测试
 *          结果每次都小于10000,因为volatie只能保证对变量的可见性，并不能保证在同一时间只有一个线程对变量进行操作。
 *          所以，volatile不是线程安全的。
 *
 * @Date: Created in 20:29 2018/6/10
 */
public class VolatileTest {

    private static volatile int COUNT = 0;

    /**
     * 十个线程分别对同一变量自增1000次
     * @param args
     */
    public static void main(String[] args) {
        for(int i = 0;i<10;i++) {
            new Thread(() -> {
                for(int j = 0; j < 1000; j++){
                    COUNT++;
                }
            }).start();
        }

        //等所有线程执行完毕后在执行
        while (Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(COUNT);
    }
}
