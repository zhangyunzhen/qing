package com.zyz.see.algo.linkedList;

/**
 * This is Description
 *
 *    题目：
 *      一个链表奇数位递增，偶数位递减，按照全局递增排序
 *
 * @author yunzhen.zhang
 * @date 2022/04/21
 */
public class Demo {


    public Node linkedSort(Node node) {

        if (node == null) return node;

        // 1.链表拆分
        Node cur = node;
        Node oddNode = cur;
        Node evenNode = cur.next;
        while (cur != null && cur.next != null) {
            Node tmp = cur.next;
            cur.next = cur.next.next;
            cur = tmp;
        }

        // 2.链表反转
        Node pre = null;
        while (evenNode != null) {
            Node next = evenNode.next;
            evenNode.next = pre;
            pre = evenNode;
            evenNode = next;
        }

        // 3.有序链表合并
        Node res = new Node(-1);
        Node head = res;
        evenNode = pre;
        while (oddNode != null && evenNode != null) {
            if (oddNode.val <= evenNode.val) {
                head.next = oddNode;
                oddNode = oddNode.next;
            } else {
                head.next = evenNode;
                evenNode = evenNode.next;
            }
            head = head.next;
        }

        if (oddNode != null) {
            head.next = oddNode;
        }

        if (evenNode != null) {
            head.next = evenNode;
        }

        return res.next;
    }


    public static void main(String[] args) {

        // case:1 -> 7 -> 2 -> 5 -> 4 -> 3
        Demo demo = new Demo();
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, node3);
        Node node5 = new Node(5, node4);
        Node node2 = new Node(2, node5);
        Node node7 = new Node(7, node2);
        Node node1 = new Node(1, node7);


        Node cur = node1;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }

        System.out.println();

        Node node = demo.linkedSort(node1);

        Node res = node;
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }

        System.out.println();
    }

    public static class Node {

        public int val;

        private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }

    }


}
