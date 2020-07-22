package com.cx.leecode.In202006;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (candidates[i] > target) {
                break;
            }
            List<Integer> item = new ArrayList<>();
            fanzhi(res, item, i, len, candidates, target);
        }
        return res;
    }

    private void fanzhi(List<List<Integer>> res, List<Integer> item, int start, int len, int[] candidates, int target) {
        if (start >= len) {
            return;
        }

        int candidate = candidates[start];

        if (candidate == target) {
            item.add(candidate);
            res.add(item);
            item.subList(0, item.size() - 1);
            return;
        }

        if (candidate < target) {
            List<Integer> list = new ArrayList<>(item);
            item.add(candidate);
            int target2 = target - candidate;
            fanzhi(res, item, start, len, candidates, target2);
            if (list.size() > 0) {
                fanzhi(res, list, start + 1, len, candidates, target);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] nums = new int[]{2, 3, 5};
        List<List<Integer>> lists = combinationSum.combinationSum(nums, 8);
        System.out.println(lists);
    }
}
