package com.zyz.algorithm.tree;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2022/03/26
 */
public class TreeDemo {

    /**
     *  二叉树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
    }


}
