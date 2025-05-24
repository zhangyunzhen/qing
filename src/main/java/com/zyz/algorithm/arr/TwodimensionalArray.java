package com.zyz.algorithm.arr;

import com.alibaba.fastjson.JSON;

/**
 * This is Description
 * <p>
 * 二维数组相关
 *
 * @author yunzhen.zhang
 * @date 2021/07/11
 */
public class TwodimensionalArray {


    /**
     * 顺时针打印矩阵
     * //题解：顺着每一条边去遍历
     *
     * @param matrix
     * @return
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        //创建数组
        int[] ints = new int[matrix.length * matrix[0].length];
        int cur = 0;

        int t = 0, b = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        while (true) {
            for (int i = l; i <= r; i++) ints[cur++] = matrix[t][i];
            if (++t > b) break;
            for (int i = t; i <= b; i++) ints[cur++] = matrix[i][r];
            if (--r < l) break;
            for (int i = r; i >= l; i--) ints[cur++] = matrix[b][i];
            if (--b < t) break;
            for (int i = b; i >= t; i--) ints[cur++] = matrix[i][l];
            if (++l > r) break;
        }
        return ints;
    }


    /**
     * 剑指 Offer 04. 二维数组中的查找
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        //找到右边顶点元素，开始遍历。
        //很像二叉树，右边顶点左边的元素比它小，右边的元素比它大
        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] ints1 = {{1, 2, 3}, {2, 4, 5}, {4, 5, 7}};
        //int[] ints1 = spiralOrder(ints);
        boolean numberIn2DArray = findNumberIn2DArray(ints1, 10);
        System.out.println(JSON.toJSONString(numberIn2DArray));
    }


}
