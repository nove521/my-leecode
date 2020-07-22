package com.cx.leecode.In202007;

import java.util.*;
import java.util.stream.Collectors;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
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
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            pailie(n, output, res, first + 1);
            Collections.swap(output, first, i);
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute1 = permute.permute(nums);
        System.out.println(permute1);
    }
}
