package com.zyz.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/09/06
 */
public class ThreadTest {


    private Object object;

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        Demo demo = new Demo();

        FutureTask futureTask = new FutureTask<>(demo);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }


    public void test() {

        synchronized (object) {


        }

    }

    public static class Demo implements Callable {

        @Override
        public Object call() throws Exception {
            return 110;
        }
    }


}
