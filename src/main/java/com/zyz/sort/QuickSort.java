package com.zyz.sort;

/**
 * @Author: YunzhenZhang
 * @Description: 快速排序
 * @Date: Created in 16:10 2018/6/26
 */
public class QuickSort {


    public static void quickSort(int[] arry, int low, int high) {

        //找到递归算法的出口
        if (low > high) {
            return;
        }

        //基准数
        int key = arry[low];
        int i = low;
        int j = high;

        //一趟排序
        while (i < j) {
            while (i < j && arry[j] >= key) {
                j--;
            }
            while (i < j && arry[i] <= key) {
                i++;
            }

            if (i < j) {
                int temp = arry[i];
                arry[i] = arry[j];
                arry[j] = temp;
            }
        }

        //分治 递归
        int temp = arry[i];
        arry[i] = arry[low];
        arry[low] = temp;
        //左边数列排序
        quickSort(arry, low, i - 1);
        //右边数列排序
        quickSort(arry, i + 1, high);
    }

    public static void test(int arry[], int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int temp = arry[low];

        while (i < j) {
            while (i < j && arry[j] >= temp) {
                j--;
            }
            while (i < j && arry[i] <= temp) {
                i++;
            }
            if (i < j) {
                int a = arry[j];
                arry[j] = arry[i];
                arry[i] = a;
            }
        }

        int bb = arry[j];
        arry[j] = arry[low];
        arry[low] = bb;

        test(arry, low, i - 1);
        test(arry, i + 1, high);
    }

    public static void main(String[] args) {
        int[] arry = {1, 9, 6, 0, 6, 4, 9, 6, 3, 7, 5, 8, 3};
        //quickSort(arry, 0, arry.length - 1);
        test(arry, 0, arry.length - 1);
        for (int i : arry) {
            System.out.println(i);
        }
    }
}
