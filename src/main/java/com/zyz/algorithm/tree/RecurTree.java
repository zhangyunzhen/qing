package com.zyz.algorithm.tree;

import java.util.LinkedList;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/09/21
 */
public class RecurTree {


    /**
     * 剑指 Offer 28. 对称的二叉树
     *
     *   题解：找到对称二叉树中：双结点和他们子节点的关系
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return recurIsSymmetric(root.left, root.right);
    }

    Boolean recurIsSymmetric(TreeNode left, TreeNode right) {
        if (left.left == null && right == null) return true;
        if (left == null) return false;
        if (right == null) return false;
        return left.val == right.val && recurIsSymmetric(left.left, right.right) && recurIsSymmetric(left.right, right.left);
    }


    /**
     * 剑指 Offer 27. 二叉树的镜像/ 翻转二叉树
     * 单个结点递归
     *
     * 公式：
     *    temp = root.left
     *    left = root.right
     *    right = left
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        mirrorTree(root.left);
        mirrorTree(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }




}











