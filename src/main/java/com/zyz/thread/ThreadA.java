package com.zyz.thread;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 17:34 2018/7/12
 */
public class ThreadA {

    static class ThreadWait extends Thread{
        @Override
        public void run() {
            synchronized (ThreadA.class){
                try {
                    System.out.println("wait before!!!");
                    ThreadA.class.wait();
                    System.out.println("wait after!!!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadWait2 extends Thread{
        @Override
        public void run() {
            synchronized (ThreadA.class){
                try {
                    System.out.println("wait2 before!!!");
                    ThreadA.class.wait();
                    System.out.println("wait2 after!!!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadNotify extends Thread{
        @Override
        public void run() {
            synchronized (ThreadA.class){
                try {
                    System.out.println("notify before!!!");
                    ThreadA.class.notify();
                    System.out.println("notify after!!!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadWait2 threadWait2 = new ThreadWait2();
        threadWait2.start();

        ThreadWait threadWait = new ThreadWait();
        threadWait.start();

        Thread.sleep(1000);
        ThreadNotify threadNotify = new ThreadNotify();
        threadNotify.start();

    }
}
