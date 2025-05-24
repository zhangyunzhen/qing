package com.zyz.thread;

import java.util.concurrent.*;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 16:47 2018/7/12
 */
public class TestThreadPool {

    public static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(1,
            2,100
            ,TimeUnit.MILLISECONDS
            ,new LinkedBlockingDeque<>(1000)
            ,new ThreadPoolExecutor.AbortPolicy());


    public static void main(String[] args) {

        // 创建3个线程的线程池
        ThreadPool t = ThreadPool.getThreadPool(3);
        t.execute(new Runnable[]{new Task(), new Task(), new Task()});
        t.execute(new Runnable[]{new Task(), new Task(), new Task()});
        System.out.println(t);
        t.destroy();// 所有线程都执行完成才destory
        System.out.println(t);

        ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(1);
        System.out.println(-1 <<29);

    }

    // 任务类
    static class Task implements Runnable {
        private static volatile int i = 1;

        @Override
        public void run() {// 执行任务
            System.out.println("任务 " + (i++) + " 完成");
        }
    }
}
