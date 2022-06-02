package com.zyz.thread;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: YunzhenZhang
 * @Description:
 *          创建线程的第三种方式：
 *              实现Callable接口
 * @Date: Created in 11:27 2018/7/15
 */
public class ThreadB {


    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("i'm call" + Thread.currentThread().getName());
            return "call return";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

/*        MyCallable myCallable = new MyCallable();
        FutureTask<String> ft = new FutureTask<String>(myCallable);
        Thread thread = new Thread(ft);
        thread.start();

        Thread.sleep(3000L);
        System.out.println(ft.get());*/

        ArrayList<Object> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(8);
        list.add(8);
        list.add(8);
        list.add(8);
        list.add(8);
        list.parallelStream().forEach(p -> System.out.println(Thread.currentThread() + "" + p));
    }
}
