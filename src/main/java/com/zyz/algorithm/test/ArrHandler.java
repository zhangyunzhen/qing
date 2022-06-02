package com.zyz.algorithm.test;

import com.google.common.collect.Lists;
import com.zyz.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/10/01
 */
public class ArrHandler {

    public int findRepeatNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (true) {
                if (nums[i] == i) {
                    break;
                }
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }

                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        FutureTask<String> stringFutureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });
        stringFutureTask.run();

    }







}
