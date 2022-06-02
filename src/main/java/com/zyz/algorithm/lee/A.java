package com.zyz.algorithm.lee;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 *  剑指 Offer 45. 把数组排成最小的数
 *
 * @author yunzhen.zhang
 * @date 2021/01/04
 */
public class A {
    public String minNumber(int[] nums) {


        // 解题思路：先把数组转换成字符串排序，排序规则：x+y>y+x,则x>y

        String[] str= new String[nums.length];
        for(int i = 0;i<nums.length;i++){
            str[i] =String.valueOf(nums[i]);
        }

        quickSort(str,0,str.length-1);

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<str.length;i++){
            stringBuilder.append(str[i]);
        }
        return stringBuilder.toString();

    }

    public void quickSort(String[] nums,int leftPos,int rightPos){
        if(leftPos>=rightPos){
            return;
        }
        // 分区
        int partition = partion(nums,leftPos,rightPos);
        quickSort(nums,leftPos,partition-1);
        quickSort(nums,partition+1,rightPos);
    }

    // 双指针法
    public int partion(String[] nums,int leftPos,int rightPos){
        int tmp = rightPos;
        int i = leftPos,j=leftPos;
        while(j<rightPos){
            if((nums[j] + nums[tmp]).compareTo(nums[tmp]+nums[j]) < 0){
                if(i!=j){
                    swap(nums,i,j);
                }
                i++;
            }
            j++;
        }
        swap(nums,i,tmp);
        System.out.println("===="+"partion"+i+"="+leftPos+"="+rightPos+"=="+ JSON.toJSONString(nums));
        return i;
    }

    public void swap(String[] nums,int left,int right){
        String temp =nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        A a = new A();
        int[] arr = {3,30,34,5,9};
        a.minNumber(arr);
    }
}
