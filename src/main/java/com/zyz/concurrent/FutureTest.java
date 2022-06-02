package com.zyz.concurrent;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Author: YunzhenZhang
 * @Description: Future和Callable就是为了实现异步执行线程，并且能拿到执行结果。
 * Callable和Ruannable一样，是用来创建执行任务的，callable是有返回值的.
 * Future的get()方法会阻塞当前线程执行，直到该future对应的线程获取到执行结果。
 * @Date: Created in 14:37 2019/6/12
 */
public class FutureTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), r -> new Thread(r, "rule_filter_"));
        FutureTask<String> stringFutureTask1 = new FutureTask<>(() -> {
            System.out.println("执行异步线程11111");
            Thread.sleep(3000L);
            System.out.println("执行异步线程1111");
            return Thread.currentThread().getName();
        });
        FutureTask<String> stringFutureTask2 = new FutureTask<>(() -> {
            System.out.println("执行异步线程222");
            return Thread.currentThread().getName();
        });
        executorService.submit(stringFutureTask1);
        System.out.println("查看是否执行完" + stringFutureTask1.isDone());
        String s = stringFutureTask1.get();
        System.out.println("查看是否执行完" + stringFutureTask1.isDone());
        executorService.submit(stringFutureTask2);
        System.out.println(s);
    }


    @Test
    public void CompletableFutureTest() throws InterruptedException {
        ExecutorService executor = new ThreadPoolExecutor(8, 20, 0L,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1000, false), r -> new Thread(r, "queryGroupList"));
        CompletableFuture<Void> aaa = CompletableFuture.runAsync(() -> {
            System.out.println("===" + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("aaa");
        }, executor);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "bbb");
        }, executor);
        aaa.join();
        voidCompletableFuture.join();
        System.out.println(Thread.currentThread().getName() + "ccc");
    }


}
