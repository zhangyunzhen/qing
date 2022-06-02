package com.zyz.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @Author: YunzhenZhang
 * @Description: 事件订阅者
 * @Date: Created in 11:21 2018/7/20
 */
public class EventListener {

    /**
     * 消息订阅者
     *      注意：需要保证只有一个参数
     * @param message
     * @throws Exception
     */
    @Subscribe
    public void listner(String message) throws Exception {
        System.out.println(Thread.currentThread().getName());
        System.out.println("recieve message：" + message);
    }

    @Subscribe
    public void listner1(String message) throws Exception {
        System.out.println(Thread.currentThread().getName());
        System.out.println("recieve message11：" + message);
    }

    @Subscribe
    public void listner(EventBean eventBean) {
        System.out.println("receive evenBean: " + eventBean.getMessage());
    }

}
