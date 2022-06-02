package com.zyz.algorithm.dp;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/11/13
 */
public class DpDemo {


    public int demo(int[] prices) {


        int max = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                max += diff;
            }

        }

        return max;
    }

}