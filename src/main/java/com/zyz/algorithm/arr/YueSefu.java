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
     *
     *  [1.-1.2.3.1.-1]
     * 剑指 Offer 42. 连续子数组的最大和
     *
     * dp[i] = Math(dp[i-1],0) + int[i]
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            max = Math.max(nums[i], max);
        }
        return max;
    }


    /**
     * 剑指 Offer II 010. 和为 k 的连续子数组的个数
     * 题解：前缀和的思路。使用hashmap的存储前缀和
     * 1231219 10
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
