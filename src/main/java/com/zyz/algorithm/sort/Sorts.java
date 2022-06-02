package com.zyz.algorithm.sort;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2020/11/15
 */
public class Sorts {


    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            Boolean flag = false;
            // 一次冒泡过程，剩余元素中选出一个最大的
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                    // 表示有数据交换
                    flag = true;
                }
            }

            // 如果没有数据交换的时候提前退出
            if (!flag) {
                break;
            }
        }
    }


    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        if (arr == null) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            // 有序队列中比较大小（从最末端开始比较）
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selecttionSort(int[] arr) {
        if (arr == null) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 找剩余元素中最小的元素
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }


    public void insertionSort2(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j >= 1; j--) {
                // j下标元素插入到有序数组中
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j-1, j);
                } else {
                    break;
                }
            }
        }
    }

    public void swap(int[] arry, int i, int j) {
        int tmp = arry[i];
        arry[i] = arry[j];
        arry[j] = tmp;
    }

    public static void main(String[] args) {
        Sorts sorts = new Sorts();
        int[] arr = {1, 3, 77, 4, 9, 4};
        sorts.insertionSort2(arr);
        System.out.println(JSON.toJSONString(arr));

      /*  int[] arr = {10, 99, 1, 9, 2, 30, 8, 10, 200, 1, 6, 3};
        selecttionSort(arr);
        System.out.println(JSON.toJSONString(arr));*/
    }
}
