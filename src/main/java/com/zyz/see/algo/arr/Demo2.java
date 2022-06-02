package com.zyz.see.algo.arr;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Description
 *          不重复字符的子字符串 (starRocks)
 *
 * @author yunzhen.zhang
 * @date 2022/04/24
 */
public class Demo2 {


    public int lengthOfLongestSubstring(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        int max = 0;
        // 窗口左指针
        int leftIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
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

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        int length = demo2.lengthOfLongestSubstring("abcddefgc");
        System.out.println(length);
    }



}
