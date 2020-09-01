package com.cx.leecode.In202008;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        for (int i = nums.length; i >= 1; i--) {
            fun(nums, nums.length, i, 0, res, item);
        }
        res.add(new ArrayList<>());
        return res;
    }

    public void fun(int[] nums, int numLens, int len, int start, List<List<Integer>> res, List<Integer> item) {
        if (len == 1) {
            for (int i = start; i < numLens; i++) {
                item.add(nums[i]);
                res.add(new ArrayList<>(item));
                item.remove(item.size() - 1);
            }
            return;
        }
        int ll = numLens - len + 1;
        for (int i = start; i < ll; i++) {
            item.add(nums[i]);
            fun(nums, numLens, len - 1, i + 1, res, item);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subsets1 = subsets.subsets(nums);
        System.out.println(subsets1);
    }
}
