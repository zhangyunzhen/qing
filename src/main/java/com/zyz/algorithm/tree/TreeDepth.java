package com.zyz.algorithm.tree;

import com.google.common.collect.Lists;
import javafx.util.Pair;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * @author yunzhen.zhang
 * @date 2021/07/18
 */
public class TreeDepth {


    /**
     * 后序遍历
     * <p>
     * 递推公式： treeDepth = Max(tree.left.depth,tree.right.depth)+1
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);

        int rightDepth = maxDepth(root.right);

        if (leftDepth > rightDepth) {
            return leftDepth + 1;
        } else {
            return rightDepth + 1;
        }
    }


    /**
     * 层序遍历
     * <p>
     * 模版：
     * while(){
     * for(){
     * <p>
     * }
     * }
     *
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        List<TreeNode> nodes = Lists.newArrayList();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            depth++;
            List<TreeNode> tmp = Lists.newArrayList();
            for (TreeNode node : nodes) {
                if (node.right != null) {
                    tmp.add(node.right);
                }
                if (node.left != null) {
                    tmp.add(node.left);
                }
            }
            nodes = tmp;
        }
        return depth;
    }


    /**
     * 判断是否是平衡二叉树
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // -10只是个变量
        return recurBalanced(root) != -10;
    }

    //倒叙求节点深度
    public static int recurBalanced(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftDepth = recurBalanced(root.left);
        if (leftDepth == -10) {
            return -10;
        }
        int rightDepth = recurBalanced(root.right);
        if (rightDepth == -10) {
            return -10;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -10;
        }
        return Math.max(leftDepth, rightDepth) + 1;

    }

}
