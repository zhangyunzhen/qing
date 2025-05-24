package com.zyz.algorithm.arr;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2020/12/02
 */
public class Arr {


    public static void main(String[] args) {
       /* int[] a = {0, 1, 1, 2, 4, 4, 1, 3, 3, 2};
        int[] topk = Arr.topk(a, 6);
        System.out.println("    " + JSON.toJSONString(topk));*/

        int i = majorityElement(new int[]{1, 2, 3, 4, 1, 1, 1, 1});
        System.out.println(i);
    }

    /**
     *  123456 3
     *
     *  456123
     *
     *  654321
     *  456
     *  123
     *
     *   数组向右旋转k元素
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        k = k % n; // 处理 k >= n 的情况
        if (k == 0) return; // 无需移动

        // 三次反转操作
        reverse(nums, 0, n - 1); // 整体反转
        reverse(nums, 0, k - 1); // 反转前 k 个元素
        reverse(nums, k, n - 1); // 反转剩余元素
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 查询数组中超过一半的数字
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int mode = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) mode = num;
            count += (mode == num) ? 1 : -1;
        }
        return mode;
    }



    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum = sum < 0 ? 0 : sum;
            sum += nums[i];
            max = Math.max(sum, max);
        }
        return sum;
    }


    /**
     * 找出数组中任意一个重复数字
     * 或者使用set
     *
     *   234562
     * 这种方式算出来时间复杂度是O(n),空间复杂度也是O(n)
     *
     * @return
     */
    public int findRepeatNumber2(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]]) return nums[i];

            // 注意交换顺序
            int temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;
        }
        return -1;
    }


    /**
     * 找出数组中所有重复数字,数字范围1-n,数组大小 n
     * [1,2,3,4,1]
     * [2,3,2,1,5]
     * [2,3,4,5]
     *  核心思想是借助数组标识正负值来标记元素是否出现，替代map存储
     *
     * @param nums
     * @return
     */
    public List<Integer> findRepeatNumber3(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int index = Math.abs(num) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                res.add(index + 1);
            }
        }
        return res;
    }

    public static int[] queryIntersection(int array1[], int array2[]) {
        if (array1 == null || array1.length == 0 || array2 == null || array2.length == 0) return new int[]{};

        int length1 = array1.length, length2 = array2.length;

        List<Integer> intersections = new ArrayList<>();

        int i = 0, j = 0, k = 0;
        while (i < length1 && j < length2) {
            if (array1[i] == array2[j]) {
                intersections.add(array1[i]);
                i++;
                j++;
            } else if (array1[i] > array2[j]) {
                j++;
            } else if (array1[i] < array2[j]) {
                i++;
            }

        }
        Integer[] integers = intersections.toArray(new Integer[intersections.size()]);
        int[] ints = Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
        return ints;
    }


    /**
     * 取top k
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] topk(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[]{};
        }
        if (k > arr.length) {
            return arr;
        }
        recur(arr, 0, arr.length - 1, k);

        int[] topArr = new int[k];
        for (int i = 0; i < k; i++) {
            topArr[i] = arr[i];
        }
        return topArr;
    }

    static void recur(int[] arr, int start, int end, int k) {
        if (start >= end) {
            return;
        }

        int pivot = partion(arr, start, end);
        if (pivot + 1 == k) {
            return;
        }
        if (pivot + 1 < k) {
            recur(arr, pivot + 1, end, k);
        }
        if (pivot + 1 > k) {
            recur(arr, start, pivot - 1, k);
        }


    }

    public static int partion(int[] arr, int start, int end) {
        int divide = start;
        int cursor = start;
        int target = arr[end];
        while (cursor < end) {
            if (arr[cursor] < target) {
                if (cursor == divide) {
                    divide++;
                } else {
                    int temp = arr[cursor];
                    arr[cursor] = arr[divide];
                    arr[divide] = temp;
                    divide++;
                }
            }
            cursor++;
        }

        //调换目标元素的位置
        int tmp = arr[divide];
        arr[divide] = target;
        arr[end] = tmp;
        System.out.println("======arr:" + JSON.toJSONString(arr) + "==start:" + start + "===end:" + end + "===divide:" + divide);
        return divide;
    }





}
