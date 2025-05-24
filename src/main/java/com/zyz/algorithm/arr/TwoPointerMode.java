package com.zyz.algorithm.arr;

import com.alibaba.fastjson.JSON;

/**
 * This is Description
 * <p>
 * 双指针法
 *
 * @author yunzhen.zhang
 * @date 2021/07/10
 */
public class TwoPointerMode {


    /**
     * 将奇数放前面，偶数放后面
     * (首尾指针法)
     * 一次移一个指针
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {

        //首尾双指针法
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if ((nums[i] & 1) == 0 && (nums[j] & 1) == 1) {
                swap(nums, i, j);
            }
            if ((nums[i] & 1) == 1) i++;
            if ((nums[j] & 1) == 0) j--;
        }
        return nums;
    }

    /**
     * 将奇数放前面，偶数放后面
     * (快慢指针法)
     * 一次移一个指针
     *
     * @param nums
     * @return
     */
    public static int[] exchange1(int[] nums) {

        //快慢双指针法
        int i = 0, j = 0;
        while (j < nums.length) {
            if ((nums[j] & 1) == 1) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
        return nums;
    }


    /**
     * 剑指 Offer 57. 递增数组和为s的两个数字
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        while (head < tail) {
            if (nums[head] + nums[tail] == target) {
                int[] result = {nums[head], nums[tail]};
                return result;
            } else if (nums[head] + nums[tail] < target) {
                head++;
            } else if (nums[head] + nums[tail] > target) {
                tail--;
            }
        }
        return null;
    }


    /**
     * 将数组以结尾元素分为两部分
     *
     *  123456
     *
     *  654321
     *
     *  1263
     *
     * @param nums
     * @return
     */
    public static int[] partition(int[] nums) {
        int num = nums[nums.length - 1];

        int low = 0;
        int high = 0;
        while (high < nums.length) {
            if (nums[high] < num) {
                swap(nums, low, high);
                low++;
            }
            high++;
        }

        // 注意 low指针最终指向的是第一个大于结尾元素的数据
        swap(nums, low , nums.length - 1);
        return nums;
    }

    public static void swap(int[] nums, int l, int r) {
        if (l == r) return;
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 7, 9};
        int[] ints = exchange1(array);
        System.out.println(JSON.toJSONString(ints));
    }
}
