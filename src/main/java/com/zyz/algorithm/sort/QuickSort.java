package com.zyz.algorithm.sort;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * This is Description
 *
 *     优化：
 *         1.基准值的选取
 *              随机选
 *              Math.random*(end-start+1)
 *         2.相同元素不重新排序
 *              三路快排
 *              int low = start;
 *
 *
 * @author yunzhen.zhang
 * @date 2021/10/29
 */
public class QuickSort {


    public int[] quickSort(int[] arr) {
        recur(arr, 0, arr.length - 1);
        return arr;
    }

    void recur(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int partition = partition(arr, start, end);
        recur(arr, start, partition - 1);
        recur(arr, partition + 1, end);

    }

    int partition1(int[] arr, int left, int right) {


        ArrayList<Integer> list = new ArrayList<>();

        int pos = right;
        int low = left;
        int high = right - 1;
        while (low <= high) {
            if (arr[low] < arr[right]) {
                low++;
            } else if (arr[high] > arr[right]) {
                high--;
            } else {
                //swap();
            }
        }
        return low;
    }

    int partition(int[] arr, int start, int end) {

        int pos = end;
        int low = start;
        int high = start;

        while (high < end) {
            if (arr[high] <= arr[pos]) {
                if (low != high) {
                    swap(arr, low, high);
                }
                low++;
            }
            high++;
        }

        swap(arr, low, pos);
        return low;
    }


    
    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] ints = quickSort.quickSort(new int[]{3, 1, 100, 99, 10, 2, 0, 2, 9, 4, 2, 3});
        System.out.println(JSON.toJSONString(ints));
    }
}
