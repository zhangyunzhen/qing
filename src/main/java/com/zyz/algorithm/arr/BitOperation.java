package com.zyz.algorithm.arr;

import java.util.ArrayList;

/**
 * This is Description
 * 位运算
 *
 * @author yunzhen.zhang
 * @date 2021/07/11
 */
public class BitOperation {


    /**
     * 找出数组中出现1次的两个数，其余数字都是出现两次
     *
     *  题解：
     *      1. 通过异或计算找到两个数位值不同的位
     *      2. 将两个数拆分到两个不同的数组中，分别进行异或计算，得到结果
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        //  应用到异或运算符

        // 1.将两个数字想办法区分到两个不同的数组（利用位与运算，两个不同的数字的某一位一定是不一样的）
        int i = 0;
        //全员异或，获取到两个元素异或的结果
        for (int num : nums) {
            i ^= num;
        }

        //找到两个元素不同的位(参考依据：不同的位 异或结果位1)
        int j = 1;
        while ((i & j) != j) {
            j = j << 1;
        }

        int x = 0;
        int y = 0;

        // 2.两个数组分别异或，得到两个数字
        for (int num : nums) {
            if ((num & j) == j) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        return new int[]{x, y};
    }

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     * 解题关键：每一位相加，之后除3取余，得到的是这个数字
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int[] temp = new int[32];
        for (int num : nums) {
            int i = 1;
            for (int j = 0; j < temp.length; j++) {
                if ((num & i) == i) {
                    temp[j]++;
                }
                i = i << 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((temp[i] % 3 & 1) == 1) {
                ans += (1 << i);
            }
        }
        return ans;
    }


    public static void main(String[] args) {

        System.out.println(0 << 2);
    }

}
