package com.cx.leecode.In202004;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * map版本
     * 时间复杂度 0（n）
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumVersionMap(int[] nums, int target) {
        Map<Integer, Integer> store = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (store.containsKey(target - nums[i])) {
                return new int[]{store.get(target - nums[i]), i};
            }
            store.put(nums[i], i);
        }
        return null;
    }
}
