package com.zyz.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 快速排序优化
 *      优化解决问题：
 *          1.重复元素多
 *          2.数组有序，导致退化成O(n^2)
 *
 *       解决方案：
 *          1.使用三路快排。 {小于基准位的区间，等于基准位的区间，大于基准为的区间}
 *          2.随机取基准位
 *
 * @author yunzhen.zhang
 * @date 2020/11/16
 */
public class OptimalQuickSort {

    static void quickSort(int[] arry) {
        if (arry == null) {
            return;
        }
        optimalQuickSort(arry, 0, arry.length - 1);
    }


    public static void swap(int[] array, int a, int b) {
        if (a == b) {
            return;
        }
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    /**
     * 优化快排：
     *      1.优化选基准值逻辑，随机选取
     *      2.三路快排，防止重复数据多次排序。
     * @param arry
     * @param leftPos
     * @param rightPos
     */
    static void optimalQuickSort(int[] arry, int leftPos, int rightPos) {
        if (leftPos >= rightPos) {
            return;
        }

        int[] ints = optimalPartion(arry, leftPos, rightPos);
        optimalPartion(arry, leftPos, ints[0] - 1);
        optimalPartion(arry, ints[1] + 1, rightPos);
    }


    /**
     *
     *   3,4,9,7,4
     *
     *   3(start,cur),4,9,7,4(end)
     *
     *   3,4(start,cur),9.7,4(end)
     *
     *   3,4(start),9(cur),7,4(end)
     *
     *   3,4(start),4(cur),7(end),9
     *
     *   3,4(start),4,7(cur,end),9
     *
     *   3,4(start),4(end),7(cur),9
     *
     * @param arry
     * @param start
     * @param end
     * @return
     */
    static int[] optimalPartion(int[] arry, int start, int end) {
        //随机选一个基准值，这个可以防止有序数组的时间复杂度变为O(n^2)    (Math.random()*(max-min)+min);
        swap(arry, (int) (Math.random() * (end - start + 1) + start), end);

        int pivot = arry[end];

        //i左边的区间都小于基准位的值
        int i = start;
        // j右边的区间都大于基准位的值
        int j = end;
        int cur = start;
        while (cur <= j) {
            if (arry[cur] == pivot) {
                cur++;
            } else if (arry[cur] < pivot) {
                // 这时候有可能在i左边，也有可能在i右边
                swap(arry, i, cur);
                cur++;
                i++;
            } else {
                swap(arry, cur, j);
                j--;
            }
        }

        return new int[]{i, j};
    }

    public static void main(String[] args) {
      /*  int[] arr = {1, 10, 99, 4, 9, 3, 2};
        quickSort(arr);
        System.out.println(JSON.toJSONString(arr));*/

        System.out.println();
    }

}
