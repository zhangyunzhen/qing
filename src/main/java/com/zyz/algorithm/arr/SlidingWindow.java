package com.zyz.algorithm.arr;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * @author yunzhen.zhang
 * @date 2021/01/05
 */
public class SlidingWindow {


    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
        int[][] aabbcc = slidingWindow.findContinuousSequence(9);
        System.out.println(JSON.toJSONString(aabbcc));
    }


    /**
     * 和为s的连续正数序列
     *
     *   9
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        if (target < 1) {
            return new int[0][0];
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        // 滑动窗口法，主要滑动窗口两个指针的移动
        int i = 1;  //滑动窗口左边指针
        int j = 1; //滑动窗口右边指针
        int divid = target / 2;
        int sum = 0; //注意，这里是不包含右边指针的
        while (i <= divid) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] arr = arr(i, j);
                arrayList.add(arr);
                sum -= i;
                i++;
            }
        }

        return arrayList.toArray(new int[arrayList.size()][]);
    }


    /**
     * 剑指 Offer 48. 最长不含重复字符的子字符串
     * abcdeb
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int max = 0;
        // 窗口左指针
        int leftIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = map.getOrDefault(c, -1);
            map.put(c, i);
            if (index >= leftIndex) { // 说明有重复数据
                // 滑动窗口向右移
                leftIndex = index + 1;
            }
            // 计算当前子字符串长度，和max做比较
            max = Math.max(max, i - leftIndex + 1);
        }
        return max;
    }

    public int[] arr(int i, int j) {
        int[] arr = new int[j - i];
        for (int t = i; t < j; t++) {
            arr[t - i] = t;
        }
        return arr;
    }
}
