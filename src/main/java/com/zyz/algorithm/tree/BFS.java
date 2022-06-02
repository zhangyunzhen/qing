package com.zyz.algorithm.tree;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/01/13
 */
public class BFS {

    /**
     * 从上到下打印二叉树
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return new int[0];
        }

        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode poll = nodes.poll();
            list.add(poll.val);
            if (poll.left != null) nodes.add(poll.left);
            if (poll.right != null) nodes.add(poll.right);
        }

        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }


    /**
     * 从上到下打印二叉树
     * 同一层的节点按从左到右的顺序打印，每一层打印到一行。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            List<Integer> integers = new ArrayList<>();
            LinkedList<TreeNode> tmp = new LinkedList<>();
            for (int i = treeNodes.size(); i > 0; i--) {
                TreeNode node = treeNodes.poll();
                integers.add(node.val);
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            res.add(integers);
            treeNodes = tmp;
        }

        return res;
    }


    /**
     * 从左到右打一行，从右到左打一行
     *  之字形
     *
     *  注意插入的时候用 addfirst 和 addlast
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        LinkedList<TreeNode> treeNodes = new LinkedList<TreeNode>();
        if (root != null) treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            LinkedList<Integer> integers = new LinkedList<>();
            for (int i = treeNodes.size(); i > 0; i--) {
                TreeNode poll = treeNodes.poll();
                if (list.size() % 2 == 0) {
                    integers.addLast(poll.val);
                } else {
                    integers.addFirst(poll.val);
                }
                if (poll.left != null) treeNodes.add(poll.left);
                if (poll.right != null) treeNodes.add(poll.right);
            }
            list.add(integers);
        }

        return list;
    }


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) return null;

        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(pRoot);

        ArrayList<ArrayList<Integer>> res = new ArrayList();

        while (!queue.isEmpty()) {

            LinkedList<Integer> list = new LinkedList();
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                TreeNode node = queue.poll();
                if ((res.size() & 1) == 1) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.addAll(list);
            res.add(arrayList);

        }
        return res;

    }
}
