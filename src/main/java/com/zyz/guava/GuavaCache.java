package com.zyz.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.*;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 22:13 2018/5/1
 */
public class GuavaCache {

    public static Map<String, String> map = new HashMap<>();

    static {
        map.put("bb", "bb");
        map.put("cc", "cc");
    }

    public static LoadingCache<String, String> cache = CacheBuilder.newBuilder()
            //设置cache的初始大小为10，要合理设置该值
            .initialCapacity(10)
            //设置并发数为5，即同一时间最多只能有5个线程往cache执行写入操作
            .concurrencyLevel(5)
            //设置cache中的数据在写入之后的存活时间为10秒
            .expireAfterWrite(10, TimeUnit.SECONDS)
            //构建cache实例
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    return "haha";
                }
            });


    static ListeningExecutorService backgroundRefreshPools =
            MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(20));
    private static final LoadingCache<String, Date> calProCache = CacheBuilder.newBuilder().recordStats()

            .maximumSize(1000).refreshAfterWrite(4, TimeUnit.SECONDS).expireAfterWrite(12, TimeUnit.MINUTES)
            .build(new CacheLoader<String, Date>() {
                @Override
                public Date load(String calType) {
                    System.out.println("refresh" + calType);
                    return new Date();
                }

                @Override
                public ListenableFuture<Date> reload(String key, Date oldValue) throws Exception {
                    return backgroundRefreshPools.submit(new Callable<Date>() {
                        @Override
                        public Date call() throws Exception {
                            System.out.println("======hahah"+Thread.currentThread().getName());
                            return new Date();
                        }
                    });
                }
            });


    @Test
    public void test9() throws Exception {
        System.out.println("a" + calProCache.get("xxxxx"));
        System.out.println("a" + calProCache.get("xxxxx"));
        System.out.println("a" + calProCache.get("xxxxx"));
        while (true) {
            //System.out.println("c" + calProCache.get("xxxxx"));
        }
    }


    @Test
    public void test() throws InterruptedException, ExecutionException {
        cache.put("aa", "aa");
        String aa = cache.getIfPresent("aa");
        System.out.println(aa);
        Thread.sleep(5000L);
        System.out.println(cache.getIfPresent("aa"));
        Thread.sleep(10000L);
        //显示为null   因为缓存的过期时间设置为10秒
        System.out.println(cache.getIfPresent("aa"));
        System.out.println(cache.get("aa"));
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        String bb = cache.get("cc");
        System.out.println(bb);
        Thread.sleep(10000L);
        String bb1 = cache.get("cc");
        System.out.println(bb1);
    }

    /**
     * cache的get()方法
     * 若缓存中没有值，根据自定义的方法获取值并将值加入缓存。
     *
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        String cc = cache.get("cc", new Callable<String>() {
            @Override
            public String call() throws Exception {
                return map.get("cc");
            }
        });
        System.out.println(cc);
        String cc1 = cache.getIfPresent("cc");
        System.out.println(cc1);
        Thread.sleep(10000L);
        System.out.println(cache.getIfPresent("cc"));
        System.out.println(cache.get("cc"));
    }
}
