package com.zyz.algorithm.tree;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/01/15
 */
public class TreeAlgo {

    /**
     * 剑指 Offer 26. 树的子结构
     * <p>
     * 题解：遍历A的每一个节点a，判断A中以a为根节点的树是否包含b树
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 先序遍历A树,每个节点都不包含B树时则返回true
        if (A == null || B == null) {
            return false;
        }
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 判断B树是否是A的子树（从根节点开始）
     *
     * @param A
     * @param B
     * @return
     */
    boolean recur(TreeNode A, TreeNode B) {


        // 注意递归终止条件
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }

        return A.val == B.val & recur(A.left, B.left) & recur(A.right, B.right);
    }



}
