package com.zyz.see.algo.arr;

/**
 * This is Description
 *      数组元素获取top k（神策）
 * @author yunzhen.zhang
 * @date 2022/04/24
 */
public class Demo {


    public int findKNumber(int[] arr, int k) {
        if (arr == null || arr.length == 0) return -1;

        int pos = recur(arr, 0, arr.length - 1, k - 1);
        return arr[pos];
    }

    public int recur(int[] arr, int start, int end, int k) {

        if (start >= end) return -1;

        int partition = partition(arr, start, end);
        if (partition > k) {
            return recur(arr, start, partition - 1, k);
        }
        if (partition < k) {
            return recur(arr, partition + 1, end, k);
        }
        return k;
    }


    int partition(int[] arr, int start, int end) {
        int pos = arr[end];

        int low = start;
        int high = end - 1;
        while (low < high) {
            if (arr[low] > pos && arr[high] < pos) {
                swap(arr, low, high);
                low++;
                high--;
                continue;
            }
            while (arr[low] < pos) low++;
            while (arr[high] > pos) high--;
        }

        swap(arr, low, end);

        return low;
    }

    public void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        int[] arr = {2, 3, 9, 7, 4, 4, 6};
        int kNumber = demo.findKNumber(arr, 2);
        System.out.println(kNumber);

    }


}
