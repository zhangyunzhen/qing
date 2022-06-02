package com.zyz.see.algo.linkedList;


/**
 * This is Description
 *
 *      一个递增有序的链表中，删除重复元素
 *
 * @author yunzhen.zhang
 * @date 2022/05/06
 */
public class Demo1 {


    /**
     *  递增有序数组中删除重复元素
     * @param node
     */
    public Node deleteDuplication(Node node) {

        if (node == null) return node;

        Node cur = node;
        Node pre = new Node();
        Node result = pre;
        pre.next = cur;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {

                while (cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return result.next;
    }


    public static void main(String[] args) {

        // case:1->2->3->4->4->6
        Node node6 = new Node(6);
        Node node4 = new Node(4, node6);
        Node node41 = new Node(4, node4);
        Node node3 = new Node(3, node41);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        Demo1 demo1 = new Demo1();
        Node node = demo1.deleteDuplication(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;

        }
    }


    public static class Node {

        public int val;

        public Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node node) {
            this.val = val;
            this.next = node;
        }

        public Node() {
        }


    }


}
