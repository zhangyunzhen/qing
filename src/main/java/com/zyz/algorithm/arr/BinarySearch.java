package com.zyz.algorithm.arr;

/**
 * This is Description
 * 二分法
 *
 * @author yunzhen.zhang
 * @date 2021/07/10
 */
public class BinarySearch {

    /**
     * 旋转数组搜索目标值
     * 7891234    8
     *
     * @param arr
     * @param target
     * @return
     */
    public int search(int[] arr, int target) {
        if(arr[0]==target)
            return 0;
        int l=0;
        int r=arr.length-1;
        int mid=0;
        while(l<=r){
            mid=l+(r-l)/2;
            //mid值==target,则继续往左搜寻，找到最小的索引，最小索引一定不为0
            if(arr[mid]==target){
                while(mid>0&&arr[mid-1]==arr[mid])  mid--;
                return mid;
            }
            //说明mid~r是递增序列，判读target是否在中间
            if(arr[mid]<arr[r]){
                if(arr[mid]<target&&target<=arr[r]) l=mid+1;
                else    r=mid-1;
            }
            //说明 l~mid 是递增序列，判读target是否在中间
            else if(arr[mid]>arr[r]){
                if(arr[l]<=target&&target<arr[mid]) r=mid-1;
                else l=mid+1;
            }
            //arr[mid]==arr[r]说明要么r~0~mid都相等，要么mid~r都相等，无论哪种r 都可以舍去
            else{
                r--;
            }
        }
        return -1;
    }

    /**
     * 0-n-1递增数组中缺失的数字
     * 1245
     *
     * @param arr
     */
    public int missingNumber(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] == mid)  i = mid + 1;
            else j = mid;
        }
        return i;
    }

    /**
     * 旋转数组中的最小数字
     * <p>
     * 2341
     * <p>
     * 6666123366
     *
     * @param stock
     * @return
     */
    public int inventoryManagement(int[] stock) {
        if (stock == null) return -1;

        int i = 0;
        int j = stock.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (stock[mid] < stock[j]) {
                j = mid;
            } else if (stock[mid] > stock[j]) {
                i = mid + 1;
            } else {
                j--;
            }
        }
        return stock[i];
    }

    /**
     * 使用二分法查找数字
     * 可以用作标准的二分法的范例，其他二分法思路可以在这个基础上改造
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
     *
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
     * 二分法查找数字第一次出现的下标
     * 1245
     *
     * @param arr
     */
    public int missingNumber1(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] < target) {
                i = mid + 1;
            } else if (arr[mid] > target) {
                j = mid - 1;
            } else {
                while (arr[mid] == target) {
                    mid--;
                }
                mid++;
                return mid;
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
     * 使用二分法尝试
     *
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

            // 这是关键
            res = mid;
            low = mid + 1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(10 / 3);
    }

}
