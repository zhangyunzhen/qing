package com.zyz.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/01/10
 */
public class BalanceTree {

    /**
     * 判断是否是平衡二叉树
     * 题解：倒序递归判断节点的左右子树是否平衡（左右子树深度绝对值是否大于1）
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return postOrder(root) != -10;
    }

    //倒叙求节点深度
    public int postOrder(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftDepth = postOrder(root.left);
        if (leftDepth == -10) {
            return -10;
        }
        int rightDepth = postOrder(root.right);
        if (rightDepth == -10) {
            return -10;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -10;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
