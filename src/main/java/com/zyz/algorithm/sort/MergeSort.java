package com.zyz.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2020/11/15
 */
public class MergeSort {

    /**
     * 归并排序
     *
     * @param arr
     */
    public static int[] mergeSort(int[] arr) {
        merge(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * 递归分解
     *
     * @param arr
     * @param leftPos
     * @param rightPos
     * @return
     */
    public static void merge(int[] arr, int leftPos, int rightPos) {
        int i = rightPos - leftPos;
        if (i == 0) {
            return;
        }
        merge(arr, leftPos, leftPos + i / 2);
        merge(arr, leftPos + i / 2 + 1, rightPos);
        merge(arr, leftPos, leftPos + i / 2, rightPos);
    }

    /**
     * 数组中两个有序块儿合并的过程
     *
     * @param arr
     * @param leftPos
     * @param leftEnd
     * @param rightPos
     * @return
     */
    public static void merge(int[] arr, int leftPos, int leftEnd, int rightPos) {

        // 选两个指针来记录两个有序数组的下标
        int curPos1 = leftPos;
        int curPos2 = leftEnd + 1;
        // 申请一个临时数组
        int[] tempArr = new int[rightPos - leftPos + 1];
        int i = 0;
        while (curPos1 <= leftEnd && curPos2 <= rightPos) {
            if (arr[curPos1] <= arr[curPos2]) {
                tempArr[i++] = arr[curPos1++];
            } else {
                tempArr[i++] = arr[curPos2++];
            }
        }

        // 当一个有序队列移完之后，另一个数组也全部复制到数组
        while (curPos1 <= leftEnd) {
            tempArr[i++] = arr[curPos1++];
        }


        while (curPos2 <= rightPos) {
            tempArr[i++] = arr[curPos2++];
        }

        System.out.println(JSON.toJSONString(arr) + "  " + leftPos + "  " + leftEnd + "   " + rightPos + "  " + JSON.toJSONString(tempArr));
        for (int j = 0; j < tempArr.length; j++) {
            arr[leftPos++] = tempArr[j];
        }

    }


    public static void main(String[] args) {
        int[] arr = {10, 99, 2, 8, 1, 8, 3, 11, 2};
        mergeSort(arr);
        System.out.println(JSON.toJSONString(arr));
    }


}
