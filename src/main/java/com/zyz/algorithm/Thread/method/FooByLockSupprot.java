package com.zyz.algorithm.Thread.method;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2022/04/14
 */
public class FooByLockSupprot {

    private int n;

    private int state = 1;

    private Map<String, Thread> map = new HashMap<>();

    public FooByLockSupprot(int n) {
        this.n = n;
    }

    public void foo(Runnable r1) {
        for (int i = 0; i < n; i++) {
            map.put("foo", Thread.currentThread());
            while (state != 1) LockSupport.park();
            r1.run();
            Thread bar = map.get("bar");
            LockSupport.unpark(bar);
        }
    }


    public void bar(Runnable r2) {
        for (int i = 0; i < n; i++) {
            map.put("bar", Thread.currentThread());
            while (state != 2) LockSupport.park();
            r2.run();
            Thread foo = map.get("foo");
            LockSupport.unpark(foo);
        }
    }


}

