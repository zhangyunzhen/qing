package com.zyz.algorithm.search;

import com.alibaba.fastjson.JSON;
import com.zyz.algorithm.tree.TreeNode;

import java.util.*;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2022/04/10
 */
public class BackTrackingDemo {


    private List<List<Integer>> res;

    private Stack<Integer> dequeue;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return res;

        res = new ArrayList<>();
        dequeue = new Stack<>();

        boolean[] flag = new boolean[nums.length];
        dfs(nums, flag);
        return res;
    }


    public void dfs(int[] nums, boolean[] flag) {
        if (dequeue.size() == nums.length) {
            res.add(new ArrayList<>(dequeue));
        }

        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == true) continue;

            flag[i] = true;
            dequeue.push(nums[i]);
            dfs(nums, flag);
            flag[i] = false;
            dequeue.pop();
        }

    }

    public static void main(String[] args) {
        BackTrackingDemo demo = new BackTrackingDemo();
        List<List<Integer>> permute = demo.permute(new int[]{1, 2, 3});
        System.out.println(JSON.toJSONString(permute));
    }


    /**
     * 步骤：
     *  1.遍历二维数组中每一个元素，让每一个元素当作起点和word做对比
     *  2.对比是否包含word单词
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        char[] chars = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; i < board[0].length; j++) {
                if (dfs(board, i, j, chars, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, char[] word, int k) {
        if (i > board.length) return false;
        if (j > board[0].length) return false;

        if (board[i][j] != (word[k])) return false;
        if (k == word.length) return true;

        return dfs(board, i + 1, j, word, k + 1) ||
                dfs(board, i, j + 1, word, k + 1) ||
                dfs(board, i - 1, j, word, k + 1) ||
                dfs(board, i, j - 1, word, k + 1);
    }


//***************************************************/

    public List<List<Integer>> res1;

    public List<Integer> list;

    public List<List<Integer>> pathSum(TreeNode root, int target) {

        dfs(root, target, 0);
        return res1;
    }

    public void dfs(TreeNode root, int target, int sum) {

        if (root == null) return;

        list.add(root.val);
        sum += root.val;
        if (sum == target) {
            res1.add(new ArrayList<>(list));
        }
        dfs(root.left, target, sum);
        dfs(root.right, target, sum);
    }

    /******************************/


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, stack, res, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int sum, Stack<Integer> stack, List<List<Integer>> res, int begin) {


        for (int i = begin; i < candidates.length; i++) {
            sum += candidates[i];
            stack.push(candidates[i]);
            if (sum == target) {
                res.add(new ArrayList<>(stack));

            } else if (sum < target) {
                dfs(candidates, target, sum, stack, res, i);
            }

            stack.pop();
            sum -= candidates[i];

        }
    }


}
