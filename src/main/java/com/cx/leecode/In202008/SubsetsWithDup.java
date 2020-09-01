package com.cx.leecode.In202008;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> item = new LinkedList<>();
        Arrays.sort(nums);
        pp(res, item, nums, 0, nums.length);
        res.add(new ArrayList<>());
        return res;
    }

    private void pp(List<List<Integer>> res, LinkedList<Integer> item, int[] nums, int start, int len) {
        if (start >= len) {
            return;
        }
        for (int i = start; i < len; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            item.addLast(nums[i]);
            res.add(new ArrayList<>(item));
            pp(res, item, nums, i + 1, len);
            item.removeLast();
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        int[] nums = new int[]{1, 2, 2};
        System.out.println(subsetsWithDup.subsetsWithDup(nums));
    }
}
