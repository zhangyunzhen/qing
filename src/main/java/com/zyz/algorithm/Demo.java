package com.zyz.algorithm;

import com.google.common.collect.Lists;
import com.zyz.algorithm.linklist.ListNode;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/10/24
 */
public class Demo {


    static {
        System.out.println("你好啊");

        TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : -1;
            }
        });


    }


    public Demo() {
        System.out.println("aaa");
    }

    public static void main(String[] args) {
        Class<Demo> demoClass = Demo.class;
    }

    public void preOrder(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }


    public void cengxuOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(treeNode);
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.poll();
            System.out.println(node.val);
            if (node.left != null) {
                treeNodes.add(node.left);
            }
            if (node.right != null) {
                treeNodes.add(node.right);
            }
        }
    }


    public void cengxuOrder2(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(treeNode);
        while (!treeNodes.isEmpty()) {
            LinkedList<TreeNode> nodes = new LinkedList<>();
            for (TreeNode node : treeNodes) {
                System.out.println(node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            treeNodes.addAll(nodes);
        }
    }


    static class TreeNode {

        private int val;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
