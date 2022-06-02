package com.zyz.algorithm.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This is Description
 *
 *      剑指 Offer 59 - II. 队列的最大值
 *      维护一个双端队列（递减队列）
 *
 * @author yunzhen.zhang
 * @date 2021/08/10
 */
public class MaxQueue {

    private Queue<Integer> queue;

    private Deque<Integer> deque;


    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        // 判断递减队列尾部有没有小于该值的
        while (!deque.isEmpty() && (deque.peekLast() < value)) {
            deque.pollLast();
        }
        deque.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        Integer data = queue.poll();
        // 判断出队的是不是最大元素，是的话递减队列也要删除
        if (data.intValue() == deque.peek().intValue()) {
            deque.poll();
        }
        return data;
    }
}

