package com.zyz.algorithm.arr;

/**
 * This is Description
 *      规律题
 * @author yunzhen.zhang
 * @date 2021/07/10
 */
public class Regular {

    /**
     * 剑指 Offer 17. 打印从1到最大的n位数
     *
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        if (n == 0) {
            return new int[0];
        }
        // 找规律题，首先得找到n和最大数字之前的一个关系  是个10的指数关系
        int end = (int) Math.pow(10, n) - 1;
        int[] arr = new int[end];
        for (int i = 1; i <= end; i++) {
            arr[i - 1] = i;
        }
        return arr;
    }


}
