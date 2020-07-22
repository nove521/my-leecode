package com.cx.leecode.In202006;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > 0 && candidates[i] == candidates[i - 1]){
                continue;
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
            return;
        }

        if (candidate < target) {
            int size = item.size();
            item.add(candidate);
            for (int i = start + 1; i < len ; i++) {
                if (i > start + 1 && candidates[i] == candidates[i - 1]){
                    continue;
                }
                fanzhi(res, item, i, len, candidates, target - candidate);
                item = item.subList(0, size);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum = new CombinationSum2();
        int[] nums = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> lists = combinationSum.combinationSum2(nums, 8);
        System.out.println(lists);
    }
}
