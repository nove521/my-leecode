package com.cx.leecode.In202009;

import java.util.*;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        pp(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void pp(List<List<Integer>> res, List<Integer> item, int k, int n, int start) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(item));
        }
        if (k == 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (n - i < 0) break;
            item.add(i);
            pp(res, item, k - 1, n - i, i + 1);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        System.out.println(combinationSum3.combinationSum3(3, 9));
    }
}
