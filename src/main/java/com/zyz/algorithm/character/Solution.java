package com.zyz.algorithm.character;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/07/28
 */
public class Solution {


    /**
     * 把字符串 s 中的每个空格替换成"%20"。
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        if (s == null) return s;

        String[] split = s.split(",");

        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char single : chars) {
            if (single == ' ') stringBuilder.append("%20");
            else stringBuilder.append(single);
        }
        return stringBuilder.toString();
    }


    /**
     * 在字符串s中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        if (s == null) return ' ';

        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        for (char singleChar : s.toCharArray()) {
            if (map.containsKey(singleChar)) map.put(singleChar, Boolean.FALSE);
            else map.put(singleChar, Boolean.TRUE);
        }

        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            Character key = entry.getKey();
            if (entry.getValue()) {
                return key;
            }
        }
        return ' ';
    }


    /**
     * 剑指 Offer 58 - I. 翻转单词顺序
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null) return null;
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        res.setLength(0);
        for (int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if (strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }

    /**
     * 剑指 Offer 58 - II. 左旋转字符串
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        if (s == null) return null;
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
     /*   StringBuffer stringBuffer = new StringBuffer();
        System.out.println('0'-'0'+'0');*/

        //double pow = Math.pow(10, 2);
        System.out.println("测试公司zbc123测试".hashCode() % 100);
    }

    /**
     * 剑指 Offer 46. 把数字翻译成字符串,有多少种不同的字符串
     * <p>
     * 动态规划解法：
     * 先定义状态：
     * dp(i)代表num的size=i时，包含的字符串数量
     * 先找出转换方程：
     * 1. dp(i) = dp(i-1) + dp(i-2)   10<=10*x(i-1)+xi<=25
     * 2. dp(i) = dp(i-1)
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {

        // 定义dp(i-2)
        int dpA = 1;
        // 定义dp(i-1)
        int dpB = 1;

        String s = String.valueOf(num);
        // 从第二个开始遍历
        for (int i = 1; i < s.length(); i++) {
            String substring = s.substring(i - 1, i + 1);
            //  dp(i) = dp(i-1) + dp(i-2)
            if (Integer.valueOf(substring) >= 10 && Integer.valueOf(substring) <= 25) {
                // dp(i) 和 dp(i-1)向前推进
                int temp = dpA;
                dpA = dpB;
                dpB += temp;
            } else {
                dpA = dpB;
            }
        }
        return dpB;
    }


    /**
     * 剑指 Offer 67. 把字符串转换成整数
     * "12313"
     * 1.判断符号位
     * 2.遍历数组 res = res*10+num
     * 要判断是否越界
     *
     * @param str
     * @return
     */
    public int strToInt(String str) {
        if (str == null || "".equals(str.trim())) return 0;
        int res = 0;

        char[] chars = str.trim().toCharArray();

        // 1.判断符号位
        // 判断遍历的起始位置
        int i = 1;
        int sign = 1;
        int bndry = Integer.MAX_VALUE / 10;

        if (chars[0] == '-') {
            sign = -1;
        } else if (chars[0] != '+') {
            i = 0;
        }

        // 2.开始遍历
        for (int j = i; j < chars.length; j++) {
            char num = chars[j];
            // 判断是否是数字
            if (num > '9' || num < '0') break;

            //判断是否越界
            if (res > bndry || res == bndry && chars[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            //计算
            res = res * 10 + (num - '0');
        }

        return res * sign;
    }



}
