package com.zyz.algorithm.tree;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2022/04/29
 */
public class TreeTransform {


    /**
     *  二叉树转为单链表
     * @param node
     */
    public void transform(TreeNode node) {

        if(node == null) return;

        recur(node,null);

    }

    public void recur(TreeNode node, TreeNode tmp) {

        if(node == null) return ;

        if (tmp == null) {
            tmp = node;
        } else {
            tmp.right = node;
            tmp = node;
        }

        recur(node.left, tmp);
        recur(node.right, tmp);
    }

}
