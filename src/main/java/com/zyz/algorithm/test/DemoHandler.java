package com.zyz.algorithm.test;

import com.zyz.algorithm.linklist.ListNode;
import com.zyz.algorithm.linklist.Node;
import com.zyz.algorithm.tree.TreeNode;

import java.util.*;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/09/30
 */
public class DemoHandler {

    public List<List<Integer>> result = new ArrayList<>();

    /**
     * 重复数字全排列
     *
     * @param arr
     * @return
     */
    public List<List<Integer>> premute(int[] arr) {

        boolean[] flag = new boolean[arr.length];
        Arrays.fill(flag, false);
        dfs(arr, flag, new Stack<>());
        return result;
    }


    public void dfs(int[] arr, boolean[] used, Stack<Integer> stack) {
        if (stack.size() == arr.length) {
            result.add(new ArrayList<>(stack));
        }

        for (int i = 0; i < arr.length; i++) {

            //判断这个元素有没有使用过
            if (used[i]) {
                continue;
            }

            stack.push(arr[i]);
            used[i] = true;
            dfs(arr, used, stack);

            used[i] = false;
            stack.pop();
        }

    }

    /**
     * 剑指 Offer 12. 矩阵中的路径
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] flag = new boolean[board.length][board[0].length];
                    if (dfs(board, i, j, word.toCharArray(), 0, flag)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // flag相当于标志位
    boolean dfs(char[][] board, int i, int j, char[] word, int m, boolean[][] flag) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || m >= word.length) return false;
        if (flag[i][j]) return false;

        if (board[i][j] != word[m]) return false;

        if (m == word.length - 1) return true;

        flag[i][j] = true;
        boolean res = dfs(board, i + 1, j, word, m + 1, flag) || dfs(board, i - 1, j, word, m + 1, flag)
                || dfs(board, i, j + 1, word, m + 1, flag) || dfs(board, i, j - 1, word, m + 1, flag);
        return res;
    }

    public static void main(String[] args) {
        char[][] chars = {{'a', 'b', 'c', 'd'}, {'e', 'f', 'g', 'h'}, {'i', 'a', 'b', 'c'}};
        DemoHandler demoHandler = new DemoHandler();
        boolean afabc = demoHandler.exist(chars, "abfcbc");
        System.out.println(afabc);
    }


    public Node mergeTwoLists(Node l1, Node l2) {


        Node cur1 = l1;
        Node cur2 = l2;

        Node head = new Node(-1);
        Node tmp = head;
        while (cur1 == null | cur2 == null) {
            if (cur1.val < cur2.val) {
                tmp.next = cur1;
                cur1 = cur1.next;
            } else {
                tmp.next = cur2;
                cur2 = cur2.next;
            }
            tmp = tmp.next;
        }

        if (cur1 == null) {
            tmp.next = cur1;
        } else {
            tmp.next = cur2;
        }
        return head.next;

    }


    public Node getKthFromEnd(Node head, int k) {

        int i = 1;
        Node cur = head;
        while (i <= k) {
            if (cur == null) {
                return null;
            }
            cur = cur.next;
            i++;
        }

        Node low = head;
        while (cur != null) {
            cur = cur.next;
            low = low.next;
        }
        return low;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode cur1 = headA;
        ListNode cur2 = headB;

        while (cur1 == null && cur2 == null) {

            if (cur1 == cur2) return cur1;
            cur1 = cur1.next == null ? headB : cur1.next;
            cur2 = cur2.next == null ? headA : cur2.next;
        }
        return null;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()) {
            List<Integer> innerResult = new ArrayList<>();
            List<TreeNode> temp = new LinkedList<>();
            for (TreeNode node : list) {
                innerResult.add(node.val);
                temp.add(node.left);
                temp.add(node.right);
            }
            result.add(innerResult);
            list = temp;
        }
        return result;
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        return backTracking(root, 0, targetSum, new LinkedList<>(), result);
    }


    public boolean backTracking(TreeNode root, int sum, int targetSum, LinkedList<Integer> nodes, List<List<Integer>> result) {

        if (root == null) return false;

        sum += root.val;
        nodes.add(root.val);
        if (sum == targetSum && root.left == null && root.right == null) return true;
        boolean b = backTracking(root.left, sum, targetSum, nodes, result);
        if(b) return b;
        boolean b1 = backTracking(root.right, sum, targetSum, nodes, result);
        if(b1) return b1;
        nodes.poll();
        return false;
        
    }


}