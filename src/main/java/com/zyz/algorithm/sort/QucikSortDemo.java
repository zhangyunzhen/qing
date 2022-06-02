package com.zyz.algorithm.sort;

import java.util.Random;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/11/11
 */
public class QucikSortDemo {


    public int[] quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        quickSort(arr, 0, arr.length - 1);
        return arr;
    }


    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int[] partition = partition(arr, start, end);
        quickSort(arr, start, partition[0] - 1);
        quickSort(arr, partition[1] + 1, end);
    }


    int[] partition(int[] arr, int start, int end) {

        //随机选一个基准位
        int pivot = start + (int) (Math.random() * (end - start + 1));
        swap(arr, pivot, end);

        int pos = arr[end];
        int i = start;
        int j = end;
        int cur = start;
        while (cur <= j) {
            if (arr[cur] < pos) {
                swap(arr, i, cur);
                i++;
                cur++;
            } else if (arr[cur] == pos) {
                cur++;
            } else if (arr[cur] >= pos) {
                swap(arr, cur, j);
                j--;
            }
        }
        return new int[]{i, j};
    }


    void swap(int[] arr, int left, int right) {
        if (left != right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }

    public static void main(String[] args) {
        QucikSortDemo qucik = new QucikSortDemo();
        int[] ints = qucik.quickSort(new int[]{3, 2, 4, 9, 5, 8, 2, 7});
        for (int i : ints) {
            System.out.print(i);
        }
        System.out.println();

    }

}
