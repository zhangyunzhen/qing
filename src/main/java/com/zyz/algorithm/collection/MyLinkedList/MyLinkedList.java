package com.zyz.algorithm.collection.MyLinkedList;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/09/18
 */
public class MyLinkedList<T> {

    public Node<T> head;

    public int length;

    public int size;

    public MyLinkedList() {
        head = null;
        this.length = 0;
    }

    public void add(int index, T t) {

        if (index < 0 || index > size) throw new IllegalArgumentException("参数异常");


        int cur = 0;
        Node node = new Node(0);
        Node tmp = node;
        while (cur != index) {
            cur++;
            tmp = tmp.next;
        }

        Node next = tmp.next;
        Node n = new Node(t);
        tmp.next = n;
        n.next = next;

        head = node.next;
    }


    static class Node<T> {
        T val;
        Node next;

        public Node(T val) {
            this.val = val;
        }
    }
}
