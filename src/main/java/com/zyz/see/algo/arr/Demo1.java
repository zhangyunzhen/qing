package com.zyz.see.algo.arr;

import java.util.Random;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2022/04/21
 */
public class Demo1 {


    /**
     * 有序递增数组中寻找目标target   （starRocks）
     * @param arr
     * @param target
     * @return
     */
    public int[] findNumber(int[] arr, int target) {
        if (arr == null || arr.length < 2) return new int[0];

        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int num = arr[low] + arr[high];

            if (num > target) {
                high--;
                continue;
            }

            if (num < target) {
                low++;
                continue;
            }

            return new int[]{arr[low], arr[high]};
        }
        return new int[0];
    }


    /**
     * 数组元素随机换位
     * @param arr
     */
    public int[] shuffle(int[] arr) {

        Random random = new Random();

        for (int i = arr.length; i > 0; i--) {
            int ran = random.nextInt(arr.length);
            int temp = arr[ran];
            arr[ran] = arr[i - 1];
            arr[i - 1] = temp;
        }
        return arr;
    }


}
