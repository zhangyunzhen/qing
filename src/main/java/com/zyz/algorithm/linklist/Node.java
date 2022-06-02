package com.zyz.algorithm.linklist;

import qunar.api.pojo.node.ListNode;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/07/18
 */
public class Node {

    public int val;

    public Node next;

    public Node random;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val,Node next) {
        this.val = val;
        this.next = next;
    }
}
