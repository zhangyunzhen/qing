package com.zyz.algorithm.collection.queue;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2022/04/06
 */
public class Myaa {

    Object[] elements; //数据元素

    int size;   //长度

    int tail;
    int head;

    void enqueue(Object o) {
        tail = (tail + 1) % size;
        if (tail>=head) {

        }

    }

    int dequeue() {
        return -1;
    }

}
