package com.zyz.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 20:58 2018/7/19
 */
public class GuavaTest {

    /**
     * preconditions
     * 功能：用作校验变量
     */
    @Test
    public void preconditionsTest() {
        Integer b = null;
        Preconditions.checkArgument(b != null, "不能为空啊");
    }

    /**
     * Joiner
     * 功能:处理字符串连接操作
     */
    @Test
    public void joinerTest2() {
        //过滤掉null值
        String join = Joiner.on(",").skipNulls().join("1", null, "3");
        //替换掉null值
        String join1 = Joiner.on(",").useForNull("2").join("1", null, "3");
        System.out.println(join);
        System.out.println(join1);
        Map<String, String> map = new HashMap<>();
        map.put("aa", "啊啊");
        map.put("bb", "版本");
        map.put("cc", "存储");
        map.put("dd", "订单");
        //连接map
        String join2 = Joiner.on(",").withKeyValueSeparator("---").join(map);
        System.out.println(join2);
    }

    /**
     * Splitter
     * 功能：用于字符串分离操作
     */
    @Test
    public void splitterTest() {
          /*
         on():指定分隔符来分割字符串
         limit():当分割的子字符串达到了limit个时则停止分割
         fixedLength():根据长度来拆分字符串
         trimResults():去掉子串中的空格
         omitEmptyStrings():去掉空的子串
         withKeyValueSeparator():要分割的字符串中key和value间的分隔符,分割后的子串中key和value间的分隔符默认是=
        */
        Iterable<String> split = Splitter.on(".").limit(3).trimResults().split(" a. b.  c.  d. e");
        System.out.println(split);//[ a, b, c,d]
        System.out.println(Splitter.fixedLength(3).split("1 2 3"));//[1 2,  3]
        System.out.println(Splitter.on(" ").omitEmptyStrings().splitToList("1  2 3"));
        System.out.println(Splitter.on(",").omitEmptyStrings().split("1,,,,2,,,3"));//[1, 2, 3]
        System.out.println(Splitter.on(" ").trimResults().split("1 2 3")); //[1, 2, 3],默认的连接符是,
        System.out.println(Splitter.on(";").withKeyValueSeparator(":").split("a:1;b:2;c:3"));//{a=1, b=2, c=3}
        System.out.println(Splitter.on(";").withKeyValueSeparator(":").split("a_b_c_d:20").get("a"));//{a=1, b=2, c=3}

    }

    /**
     * EventBus
     *  事件总线（发布-订阅模式）
     *  使用方式：
     *      1.编写订阅者类，通过参数类型来识别监听哪个事件
     *      2.创建EventBus类并将订阅者实例注册到eventbus上
     *      3.调用post方法发布消息
     */
    @Test
    public void eventBusTest(){
        //同步事件总线
        EventBus eventBus = new EventBus();
        eventBus.register(new EventListener());
        eventBus.post("haha");
        EventBean eventBean = new EventBean();
        eventBean.setMessage("benben");
        eventBus.post(eventBean);

        System.out.println("================================================================");

        //异步事件总线
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1000), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"event thread");
            }
        });
        AsyncEventBus asyncEventBus = new AsyncEventBus(threadPoolExecutor);
        asyncEventBus.register(new EventListener());
        asyncEventBus.post("bbb");

    }


}
