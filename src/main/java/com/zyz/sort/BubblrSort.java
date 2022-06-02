package com.zyz.sort;

/**
 * @Author: YunzhenZhang
 * @Description: 冒泡排序
 * @Date: Created in 10:57 2018/6/25
 */
public class BubblrSort {


    private static int[] bubbleSort(int[] arry) {
        for (int i = 0; i < arry.length - 1; i++) {
            for (int j = 0; j < arry.length - i - 1; j++) {
                if (arry[j] > arry[j + 1]) {
                    int temp = arry[j + 1];
                    arry[j + 1] = arry[j];
                    arry[j] = temp;
                }
            }
        }
        return arry;
    }


    public static void test(int[] arry) {
        for (int i = 0; i < arry.length - 1; i++) {
            for (int j = 0; j < arry.length - 1 - i; j++) {
                if (arry[j] > arry[j + 1]) {
                    int temp = arry[j];
                    arry[j] = arry[j + 1];
                    arry[j + 1] = temp;
                }
            }
        }

    }


    public static void main(String[] args) {
        int[] arry = {1, 9, 4, 6, 2, 8, 4, 1};
    /*    int[] ints = bubbleSort(arry);
        for (int a : ints) {
            System.out.println(a);
        }*/
        test(arry);
        for (int a : arry) {
            System.out.println(a);
        }
    }
}
