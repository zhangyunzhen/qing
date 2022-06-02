package com.zyz.algorithm.search;

import com.google.common.collect.Lists;
import com.zyz.algorithm.tree.TreeNode;

import java.util.*;

/**
 * 回溯
 *
 * @author yunzhen.zhang
 * @date 2021/08/01
 */
public class DFS_Backtraking {

    // 结果集
    public List<List<Integer>> result = new ArrayList<>();

    /**
     * 数字全排列(无重复数字)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] used = new boolean[nums.length];
        LinkedList<Integer> path = new LinkedList<>();
        dfs1(0, nums, path, used);
        return result;
    }


    /**
     * 状态变量：
     * 1.层数（用于做终止条件）
     * 2.待排列数字(使用栈结构)
     * 3.已排列数字
     * <p>
     * 重点：状态重置
     * 解题思路：考虑清楚状态变量，只考虑一到两层。
     *
     * @return
     */
    void dfs1(int depth, int[] nums, Deque<Integer> path, boolean[] used) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            Integer integer = nums[i];
            path.addLast(integer);
            dfs1(depth + 1, nums, path, used);
            used[i] = false;
            path.removeLast();
        }
    }


    //---------------------------------------------------------------------------------------//


    public List<List<Integer>> uniqueResult = new ArrayList<>();

    /**
     * 47. 全排列 II
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {

        boolean[] flag = new boolean[nums.length];

        dfs2(nums, flag, new Stack<>());
        return uniqueResult;
    }

    public void dfs2(int[] nums, boolean[] used, Stack<Integer> stack) {
        if (stack.size() == nums.length) {
            uniqueResult.add(new ArrayList<>(stack));
        }

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Boolean flag = map.get(nums[i]);
            if (!used[i] && !Boolean.TRUE.equals(flag)) {
                // 改变状态
                map.put(nums[i], Boolean.TRUE);
                used[i] = true;
                stack.push(nums[i]);
                dfs2(nums, used, stack);

                used[i] = false;
                stack.pop();
            }

        }
    }

    //------------------------------------------------------------------//

    /**
     * 剑指 Offer 38. 字符串的排列 (有重复)
     *
     * @param s
     * @return
     */
    public String[] permutation(String s) {

        char[] chars = s.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        boolean[] used = new boolean[chars.length];

        dfs(chars, res, path, used);
        return res.toArray(new String[res.size()]);
    }

    void dfs(char[] nums, List<String> res, StringBuilder path, boolean[] used) {
        if (path.length() == nums.length) {
            res.add(path.toString());
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            // 剪枝，去重(同一层出现相同元素，剪枝)
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);

            used[i] = true;
            path.append(nums[i]);
            dfs(nums, res, path, used);
            used[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }

    // ------------------------------------------------------------------------------//


    /**
     * 剑指 Offer 34. 二叉树中和为某一值的路径（从根结点到叶子结点）
     */
    public List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return list;

        dfs(root, 0, sum, new Stack<>());
        return list;
    }

    public void dfs(TreeNode root, int k, int sum, Stack<Integer> stack) {
        if (root == null) return;

        k += root.val;
        stack.push(root.val);
        if (root.left == null && root.right == null && k == sum) {
            list.add(new ArrayList<>(stack));
        }

        dfs(root.left, k, sum, stack);
        dfs(root.right, k, sum, stack);
        stack.pop();
    }


    //-----------------------------------------------------------------------------------//


    /**
     * 剑指offer热题  39. 组合总和（一个数字可以重复利用多次）
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        ArrayList<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, new LinkedList<>(), result, 0);
        return result;
    }


    /**
     * @param candidates
     * @param target
     * @param sum
     * @param deque
     * @param result
     * @param begin      begin是为了去重
     */
    public void dfs(int[] candidates, int target, int sum, LinkedList<Integer> deque, List<List<Integer>> result, int begin) {


        // 这个题要注意i=begin这个地方，是为了去重
        for (int i = begin; i < candidates.length; i++) {
            sum += candidates[i];
            deque.add(candidates[i]);

            if (sum == target) {
                result.add(new ArrayList<>(deque));
            } else if (sum < target) {
                dfs(candidates, target, sum, deque, result, i);
            }

            sum -= candidates[i];
            deque.removeLast();
        }

    }

    //------------------------------------------------------------------------------//

    /**
     * 剑指 Offer 13. 机器人的运动范围
     * 判断数位之和不大于k的个数
     * （注意符合条件的是个等腰三角形）
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {

        // 代表走过的路径
        boolean[][] arr = new boolean[m][n];
        // 从0开始遍历
        return dfs(arr, m, n, 0, 0, k);
    }

    public int dfs(boolean[][] arr, int m, int n, int i, int j, int k) {

        // 不符合数位之和
        if (i >= m || j >= n || comput(i, j) > k || arr[i][j]) {
            return 0;
        }
        arr[i][j] = true;

        return dfs(arr, m, n, i + 1, j, k) + dfs(arr, m, n, i, j + 1, k) + 1;
    }

    // 数位之和
    public int comput(int x, int y) {
        int a = 0;
        while (x != 0) {
            a += x % 10;
            x = x / 10;
        }

        while (y != 0) {
            a += y % 10;
            y = y / 10;
        }
        return a;
    }


//--------------------------------------------------------------------//

    /**
     * 剑指 Offer 12. 矩阵中的路径
     * 判断矩阵中是否包含这个单词
     * <p>
     * （图搜索）
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 从矩阵中每一个结点开始判断
     *
     * @param board
     * @param i
     * @param j
     * @param word
     * @param k
     * @return
     */
    public boolean dfs(char[][] board, int i, int j, String word, int k) {

        // 不符合判断条件,直接返回  (剪枝)
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(k)) {
            return false;
        }

        // 已经满足条件了
        if (word.length() - 1 == k) {
            return true;
        }

        //相当于标记一下走过的路径，防止重复扫。（剪枝操作）
        board[i][j] = '-';
        boolean res = dfs(board, i + 1, j, word, k + 1) || dfs(board, i, j + 1, word, k + 1) ||
                dfs(board, i - 1, j, word, k + 1) || dfs(board, i, j - 1, word, k + 1);
        board[i][j] = word.charAt(k);
        return res;
    }




    /**
     * 剑指offer热题100 78. 子集
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) return result;

        backtracking(nums, 0, new LinkedList<>(), result);
        return result;
    }

    /**
     * 注意begin的设置，为了去重
     * @param nums
     * @param begin
     * @param list
     * @param result
     */
    void backtracking(int[] nums, int begin, LinkedList<Integer> list, List<List<Integer>> result) {
        result.add(new LinkedList<>(list));

        for (int i = begin; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(nums, i + 1, list, result);
            list.removeLast();
        }

    }


    /********************************************************/


    private List<List<Integer>> res;

    private Deque<Integer> deque;

    /**
     *
     * 给你n个数,选出中[1,n]中所有可能的k个数的组合
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 0 || k < 0 || n < k) return res;

        boolean[] flag = new boolean[n];

        deque = new LinkedList<>();
        res = new ArrayList<>();

        //  dfs(n, 0, k, flag);
        return res;
    }


    void dfs(int n, int length, int k, int startIndex) {

        if (length == k) {
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = startIndex; i < n; i++) {
            deque.addLast(i);


            // dfs()
        }
    }


//----------------------------------------------------------------------------------------//

    public static void main(String[] args) {
       /* DFS_Backtraking dfs = new DFS_Backtraking();
        int[] nums = {1, 2, 3};
        dfs.permute(nums);*/

        LinkedList<Character> strings = new LinkedList<>();
        strings.add('a');
        strings.add('b');
        strings.add('c');

    }
}
