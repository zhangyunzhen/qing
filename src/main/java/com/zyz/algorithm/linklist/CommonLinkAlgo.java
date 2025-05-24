package com.zyz.algorithm.linklist;

import java.util.LinkedList;
import java.util.Stack;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/07/18
 */
public class CommonLinkAlgo {


    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * 解法：使用递归 或者 栈的思想
     * 1->2->3->4->5
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param head
     * @return
     */
    public int[] reversePrint(Node head) {
        if (head == null) {
            return null;
        }


        // 使用stack 后进先出的思想
        Stack<Integer> nodes = new Stack<Integer>();
        while (head != null) {
            nodes.push(head.val);
            head = head.next;
        }

        int[] ints = new int[nodes.size()];
        int i = 0;
        while (!nodes.empty()) {
            ints[i++] = nodes.pop();
        }

        return ints;
    }

    /**
     * 寻找公共节点
     * 解题思路：两个链表从起始节点到公共节点走过的路径是一样的
     * 时间复杂度：O(n+m)
     * 空间复杂度：O(1)
     * 1 2 3 4 5 6
     * 7 8 5 6
     *
     * @param left
     * @param right
     * @return
     */
    public Node searchCommonNode(Node left, Node right) {
        if (left == null || right == null) {
            return null;
        }

        // 注意判断条件
        Node node1 = left;
        Node node2 = right;
        while (node1 != node2) {
            node1 = node1 == null ? right : node1.next;
            node2 = node2 == null ? left : node2.next;
        }
        return node1;
    }

    /**
     * 链表反转
     * 题解：两个节点之间的指针方向转换。
     * // 1->2->3->4
     * 1<-2<-3<-4
     *
     * @param head
     * @return
     */
    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }


    /**
     * 剑指 Offer 18. 删除链表的节点
     *
     * @param head
     * @param val
     * @return
     */
    public Node deleteNode(Node head, int val) {
        if (head == null) return null;

        Node pre = new Node(-1);
        pre.next = head;

        Node cur = pre;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return pre.next;
    }

    /**
     * 删除链表中的倒数第n个节点
     * 1-2-3-4-5
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode cur = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }

        ListNode low = new ListNode(-1);
        ListNode tmp = low;

        low.next = head;
        while (cur != null) {
            low = low.next;
            cur = cur.next;
        }
        low.next = low.next.next;

        return tmp.next;
    }


    /**
     * 寻找链表的中间节点
     * 题解：快慢指针，快指针走一步，慢指针走两步
     * 1->2->3->4
     *
     * @param head
     * @return
     */
    public Node middleNode(Node head) {
        if (head == null) return null;
        Node low = head;
        Node high = head;
        while (high != null && high.next != null) {
            low = low.next;
            high = high.next.next;
        }
        return low;
    }

    /**
     * 查找中间节点
     *
     * @param head
     * @return
     */
    public Node middleNode1(Node head) {
        if (head == null) return null;

        Node low = head;
        Node high = head;

        // 注意判断条件
        while (high.next != null && high.next.next != null) {
            high = head.next.next;
            low = low.next;
        }
        return low;
    }

    /**
     * 剑指 Offer II 027. 回文链表
     *
     * @param node
     */
    public boolean isPalindrome(Node node) {
        if (node == null) {
            return false;
        }

        // 快慢指针找中点
        Node low = node, high = node;
        while (high != null && high.next != null) {
            low = low.next;
            high = high.next.next;
        }


        Node cur = low;
        // 反转后面链表
        Node pre = null;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        // 对比
        while (pre.val == node.val) {
            pre = pre.next;
            node = node.next;
            if (pre == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * 剑指 Offer 25. 合并两个有序的链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Node headNode = new Node(-1);
        Node cur = headNode;

        Node cur1 = l1;
        Node cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val > cur2.val) {
                cur.next = cur2;
                cur2 = cur2.next;
            } else {
                cur.next = cur1;
                cur1 = cur1.next;
            }
            cur = cur.next;
        }

        if (cur1 != null) {
            cur.next = cur1;
        }

        if (cur2 != null) {
            cur.next = cur2;
        }

        return headNode.next;
    }

    /**
     * 141. 判断是否有环
     * <p>
     * 解题方法：快慢指针，如果有环，两指针一定会遇到
     * 时间复杂度：O(n+k*m)
     * 空间复杂度：
     *
     * @param head
     * @return
     */
    public boolean hasCycle(Node head) {
        Node low = head;
        Node fast = head;
        while (fast != null && fast.next != null) {

            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                return true;
            }
        }
        return false;
    }


    /**
     * 判断环起点
     * <p>
     * 注意：
     * 快慢指针找到交点以后，慢指针重新从原点触发，快指针直接继续绕环，再次相交点就是环起点（可证明）
     * <p>
     * 注意证明逻辑
     *
     * @param head
     * @return
     */
    public Node detectCycle(Node head) {

        // 1.先判断是否有环，找到快慢指针相交处
        Node low = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) return null;

        // 2.再找相交处
        low = head;
        while (low != fast) {
            low = low.next;
            fast = fast.next;
        }

        return low;

    }


    /**
     * 输出倒数第n个k的节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;

        // 第一个指针走到k节点的位置
        ListNode high = head;
        for (int i = 0; i < k; i++) {
            high = high.next;
        }

        // 两个指针同时走，直到第一个指针为null
        ListNode low = head;
        while (high != null) {
            low = low.next;
            high = high.next;
        }

        return low;
    }


    /**
     * 61.旋转链表，将链表每个元素向右移动k个位置
     *
     * @param head
     * @param k
     * @return
     */
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

        // 2.找到第倒数k个元素
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


    /**
     * 问题描述
     * 两个不定长单向链表，将链表的数据按右对齐的方式，对应位相加，给出一个新链表。相加结果超过10，向前进位。高位在链表头，低位在链表尾段
     * 不推荐使用链表反转方式
     * 示例
     * 7243 + 564 = 7807
     * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 8 -> 0 -> 7
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return l1;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode cur1 = l1;
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        ListNode cur2 = l2;
        while (cur1 != null) {
            list1.addFirst(cur1.val);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            list2.addFirst(cur2.val);
            cur2 = cur2.next;
        }

        ListNode res = new ListNode(0);
        int tag = 0;
        while (!list1.isEmpty() && (!list2.isEmpty())) {
            Integer poll1 = list1.poll();
            Integer poll2 = list2.poll();
            int num = poll1 + poll2 + tag;
            tag = num / 10;
            ListNode listNode = new ListNode(num % 10);
            // 头插法
            listNode.next = res.next;
            res.next = listNode;
        }

        while (!list1.isEmpty()) {
            Integer poll = list1.poll();
            int num = poll + tag;
            tag = num / 10;
            ListNode node = new ListNode(num % 10);
            node.next = res.next;
            res.next = node;
        }

        while (!list2.isEmpty()) {
            Integer poll1 = list2.poll();
            int num = poll1 + tag;
            tag = num / 10;
            ListNode node = new ListNode(num % 10);
            node.next = res.next;
            res.next = node;
        }


        if (tag > 0) {
            res.val = 1;
        } else {
            res = res.next;
        }
        return res;
    }


}
