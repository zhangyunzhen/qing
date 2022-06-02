package com.zyz.algorithm.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/01/19
 */
public class SumTree {


    public LinkedList<Integer> tmp = new LinkedList<>();

    public LinkedList<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }


    public void recur(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        tmp.add(root.val);

        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(tmp));
            tmp.removeLast();
            return;
        }

        recur(root.left, sum);
        recur(root.right, sum);

        // 这一步删除的逻辑比较难理解
        tmp.removeLast();
    }

}
