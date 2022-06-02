package com.zyz.see.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * Boss直聘：
 *      getIpCount(String ip)方法实现根据ip字符串计数
 *
 * 注意几点：
 *      1.要用String.intern()，因为字符串有可能不是一个内存地址
 *      2.注意上锁的范围
 *
 * @author yunzhen.zhang
 * @date 2021/10/20
 */
public class IncreCountDemo {


    public Map<String, AtomicInteger> map = new HashMap<>();


    public int getIpCount(String ip) {
        AtomicInteger count;

        count = map.get(ip.intern());
        if (count == null) {
            synchronized (ip.intern()) {
                count = map.get(ip.intern());
                if (count == null) {
                    count = new AtomicInteger(0);
                    map.put(ip.intern(), count);
                }
            }
        }
        int i = count.incrementAndGet();
        return i;
    }

    public static void main(String[] args) {

        IncreCountDemo demo = new IncreCountDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int ipCount = demo.getIpCount("111");
                System.out.println(ipCount);
            }).start();
        }
    }
}
