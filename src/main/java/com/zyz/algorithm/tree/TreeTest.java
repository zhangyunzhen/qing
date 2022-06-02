package com.zyz.algorithm.tree;

import java.util.*;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2022/04/04
 */
public class TreeTest {


    public boolean recur(int[] arr, int left, int right) {

        if (left >= right) return true;

        // 左，右，中

        int root = arr[right];

        int i = left;
        while (arr[i] < root) {
            i++;
        }

        int mid = i;

        while (arr[i] > root) {
            i++;
        }
        return i == right && recur(arr, left, mid - 1) && recur(arr, mid, right);

    }


    public class TreeNode {

        public int val;

        public TreeNode left;

        public TreeNode right;

    }


}
