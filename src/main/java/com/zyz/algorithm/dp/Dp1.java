package com.zyz.algorithm.dp;

import java.util.Arrays;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2022/05/01
 */
public class Dp1 {

    /**
     * 1143. 最长公共子序列
     *      "abcdc" 和 "bd"的最长公共子序列是2
     *
     *  状态变量：
     *      dp[i][j]:代表长度为i的字符串和长度为j的字符串的最长公共子序列
     *
     *  状态方程：
     *      if(text1[i-1] == text[j-1]) dp[i][j] = dp[i-1][j-1]+1
     *      else   dp[i][j] = max(dp[i-1][j],dp[i][j-1])
     *
     *
     *  初始变量：
     *      dp[0][0] = 0;
     *      dp[1][0] = 0;
     *      dp[0][1] = 0;
     *
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {

        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return -1;


        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = 0;

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }


    /**
     *
     * 718. 最长重复子数组
     *      {1,3,4,5} {3,4,5} 最长重复子数组为3
     *
     *      dp[i][j]代表以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return 0;

        int max = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    /**
     * 300. 最长递增子序列
     *
     *  状态变量：
     *      dp[i]代表长度为i的最长递增子序列
     *
     *  状态方程：
     *      Math.max(dp[i], dp[j] + 1);
     *
     *  初始变量：
     *      dp[1] = 1;
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];

        int res = 0;
        Arrays.fill(dp, 1);


        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }


}
