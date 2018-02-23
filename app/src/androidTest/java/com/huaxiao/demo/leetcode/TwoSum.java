package com.huaxiao.demo.leetcode;

import android.support.annotation.Nullable;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

/**
 * Description TODO
 * Author sunhuaxiao
 * Date 2018/2/23
 */

@RunWith(AndroidJUnit4.class)
public class TwoSum {

    @Test
    public void solution() {
        int[] a = new int[]{2, 7, 11, 19};
        int target = 9;
        int[] b = twoSum(a, target);
        System.currentTimeMillis();
    }

    @Nullable
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;

        int[] array = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];

            if (map.containsKey(target - key)) {
                array[0] = map.get(target - key);
                array[1] = i;
                return array;
            }

            map.put(key, i);
        }

        return null;
    }

}
