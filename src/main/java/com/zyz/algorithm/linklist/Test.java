package com.zyz.algorithm.linklist;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2022/04/03
 */
public class Test {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) return head;

        // 获取链表的长度，对k取余
        ListNode cur1 = head;
        int size = 0;
        while (cur1 != null) {
            size++;
            cur1 = cur1.next;
        }

        k = k % size;


        // 1.找到第k个元素
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }

        // 2.找到倒数k个元素
        ListNode low = head;
        while (cur.next != null) {
            low = low.next;
            cur = cur.next;
        }

        // 3.将倒数k个元素移动到链表头部
        cur.next = head;
        head = low.next;
        low.next = null;
        return head;
    }


    public class Node {

        private int val;

        private Node next;

        public Node() {

        }

        public void Node(int val, Node next) {
            this.val = val;
            this.next = next;

        }

    }


}
