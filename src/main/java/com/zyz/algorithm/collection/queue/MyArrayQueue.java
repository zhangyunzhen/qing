package com.zyz.algorithm.collection.queue;


/**
 *  自己实现的数组队列
 *      特点：
 *          先入先出，队尾入队，队头出队
 *      主要参数：
 *          object[] items     //存放队列元素
 *          int head          //队列头部
 *          int tail          //队列尾部
 *          int capcity       //队列长度
 *
 *      主要方法：
 *          boolean enQueue(E value); //入队
 *          E deQueue();        //出队
 *          int size();        //队列长度
 *
 *
 *  注意：
 *      size的计算
 *      enqueue和dequeue中队列满和空的判断条件，这里tail要指向的元素是空，head指向的元素是有值
 *
 * @author yunzhen.zhang
 * @date 2021/10/25
 */
public class MyArrayQueue<E> {


    // 数组：items，数组大小：n
    private Object[] items;

    private int capacity = 0;

    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public MyArrayQueue(int capacity) {
        items = new Object[capacity + 1];
        this.capacity = capacity + 1;
    }

    // 入队
    public boolean enqueue(E item) {
        // 判断队列是否满了
        if ((tail + 1) % capacity == head) return false;
        items[tail] = item;
        tail = (tail + 1) % capacity;
        return true;
    }

    // 出队
    public E dequeue() {
        // 如果head == tail 表示队列是否为空
        if (head == tail) return null;

        Object ret = items[head];
        head = (head + 1) % capacity;
        return (E) ret;
    }

    public void printAll() {
        if (0 == capacity) return;
        for (int i = head; i % capacity != tail; i = (i + 1) % capacity) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }


    public E getFirst() {
        return (E) items[head];
    }

    public E getLast() {
        return (E) items[tail];
    }

    public int size() {
        int diff = tail - head;
        if (diff < 0)
            diff += capacity;
        return diff;
    }

    public static void main(String[] args) {
        MyArrayQueue circularQueue = new MyArrayQueue(5);
        System.out.println(circularQueue.enqueue("a"));
        System.out.println(circularQueue.enqueue("b"));
        System.out.println(circularQueue.enqueue("c"));
        System.out.println(circularQueue.enqueue("d"));
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.enqueue("f"));
        System.out.println(circularQueue.enqueue("e"));
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.size());
    }

}
