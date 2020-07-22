package com.cx.leecode.In202007;

import java.util.*;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        ArrayList<Integer> collect = new ArrayList<>();
        for (int num : nums) {
            collect.add(num);
        }

        pailie(nums.length, collect, res, 0);
        return res;
    }

    public void pailie(int n,ArrayList<Integer> output, List<List<Integer>> res, int first) {
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        Map<Integer,Integer> h = new HashMap<>();
        for (int i = first; i < n; i++) {
            int val = output.get(i);
            if (h.get(val) != null)
                continue;
            h.put(val,1);
            Collections.swap(output, first, i);
            pailie(n, output, res, first + 1);
            Collections.swap(output, first, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        PermuteUnique permuteUnique = new PermuteUnique();
        List<List<Integer>> lists = permuteUnique.permuteUnique(nums);
        System.out.println(lists);
    }
}
