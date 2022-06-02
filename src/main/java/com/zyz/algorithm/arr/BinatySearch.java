package com.zyz.algorithm.arr;

/**
 * This is Description
 * 二分法
 *
 * @author yunzhen.zhang
 * @date 2021/07/10
 */
public class BinatySearch {


    /**
     * 使用二分法查找数字
     *   可以用作标准的二分法的范例，其他二分法思路可以在这个基础上改造
     *
     * @param array
     * @param value
     */
    public static int binarySearch(int[] array, int value) {
        if (array == null || array.length < 0) {
            return -1;
        }

        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 查找数组中第一个大于等于元素value的值
     * @param a
     * @param value
     * @return
     */
    public int bsearch(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 统计一个数字在排序数组中出现的次数。
     * <p>
     * 时间复杂度(O(logn))
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchCount(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int low = 0, high = nums.length - 1;
        // 要注意二分法的条件判断
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                while (nums[mid] == target) {
                    mid--;
                }
                mid++;
                int count = 0;
                while (mid < nums.length && nums[mid] == target) {
                    mid++;
                    count++;
                }
                return count;
            }

        }
        return 0;
    }


    /**
     * 求平方根
     *      使用二分法尝试
     * @param x
     * @return
     */
    public int mySqrt(int x) {

        int low = 0;
        int high = x;

        int res = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid > x) {
                high = mid - 1;
                continue;
            }

            if (mid * mid == x) {
                res = mid;
                break;
            }

            res = mid;
            low = mid + 1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(10 / 3);
    }

}
