package com.zyz.algorithm.arr;

import java.util.HashMap;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/01/06
 */
public class YueSefu {

    /**
     * 剑指 Offer 42. 连续子数组的最大和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        while (i < nums.length) {
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                sum = 0;
            }
            i++;
        }
        return sum;
    }


    /**
     * 剑指 Offer II 010. 和为 k 的连续子数组的个数
     * 题解：q前缀和的思路。使用hashmap的存储前缀和
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        // 使用hashmap来存储前缀和，value存放着这样的前缀和的个数
        // 有sum-k的前缀和说明 就有这样的解法
        HashMap<Integer, Integer> pre_sum = new HashMap<>();
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum == k) count++;
            count += pre_sum.getOrDefault(sum - k, 0);
            pre_sum.put(sum, pre_sum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


    public double myPow(double x, int n) {
        if (n == 0) {
            return x = 1;
        } else if (n < 0) {
            // 要考虑 n=integer.minValue的情况
            return 1 / x * myPow(1 / x, -n - 1);
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(1 >> 3);
    }


}
