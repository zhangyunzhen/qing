package com.zyz.algorithm.collection.queue;

/**
 * 链式队列
 *      重要变量：
 *          Node node;  //存放队列元素
 *          Node head;  //队列头部
 *          int capcity; //容量
 *          int currentLength //当前容量
 *      重要方法：
 *          boolean enQueue(E val);
 *          E deQueue();
 *          int size();
 *
 *  链表尾部入队，链表头部出队，这样使用单链表就可以
 *
 *
 * @author yunzhen.zhang
 * @date 2021/10/26
 */
public class MyLinekdQueue<E> {

    private Node tail;  //存放队列元素

    private Node head;  //队列头部

    private int currentLength; //当前容量

    public MyLinekdQueue() {
    }

    public boolean enQueue(E val) {
        if (head == null) {
            Node<E> node = new Node<>(val, null);
            head = node;
            tail = node;
        } else {
            Node<E> tmp = new Node<>(val, null);
            tail.next = tmp;
            tail = tail.next;
        }
        currentLength++;
        return true;
    }

    public E deQueue() {
        if (head == null) return null;

        Node tmp = head;
        head = head.next;
        currentLength--;
        return (E) tmp.val;
    }

    public int size() {
        return currentLength;
    }


    public static void main(String[] args) {
        MyLinekdQueue<String> queue = new MyLinekdQueue<>();
        System.out.println(queue.enQueue("a"));
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue("b"));
        System.out.println(queue.enQueue("c"));
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue("d"));
        System.out.println(queue.size());
    }

    class Node<E> {

        private E val;

        private Node next;

        public Node(E val, Node next) {
            this.val = val;
            this.next = next;
        }

        public E getVal() {
            return val;
        }

        public void setVal(E val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
