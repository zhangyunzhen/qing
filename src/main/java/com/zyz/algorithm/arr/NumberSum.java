package com.zyz.algorithm.arr;

import java.util.*;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/10/01
 */
public class NumberSum {

    /**
     * map + 数组
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();

        for (int num = 0; num < nums.length; num++) {
            if (map.getOrDefault(target - nums[num], -1) >= 0) {
                return new int[]{num, map.get(target - nums[num])};
            }
            map.put(nums[num], num);
        }
        return new int[0];
    }


    /**
     * 三数之和
     * <p>
     * 求解方式：
     * 排序+双指针
     * 注意：要注意去重逻辑
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int target = 0 - num;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int m = i + 1;
            int n = nums.length - 1;
            while (m < n) {
                if (nums[m] + nums[n] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    list.add(nums[m]);
                    list.add(nums[n]);
                    res.add(list);

                    int temp = nums[m];
                    m++;
                    while (m < nums.length && nums[m] == temp) {
                        m++;
                    }

                    int nTemp = nums[n];
                    n--;
                    while (n > 0 && nums[n] == nTemp) {
                        n--;
                    }
                } else if (nums[m] + nums[n] < target) {
                    m++;
                } else {
                    n--;
                }
            }

        }
        return res;
    }
}
