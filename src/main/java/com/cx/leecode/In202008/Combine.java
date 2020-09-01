package com.cx.leecode.In202008;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> item = new ArrayList<>();
        fun(n, k, 1, k, item, res);
        return res;
    }

    private void fun(int n, int k, int i, int cen, ArrayList<Integer> item, List<List<Integer>> res) {
        if (cen == 1) {
            for (; i <= n; i++) {
                item.add(i);
                res.add(new ArrayList<>(item));
                item.remove(item.size() - 1);
            }
            return;
        }
        int len =  n - cen + 1;
        for (; i <= len; i++) {
            item.add(i);
            fun(n, k, i + 1, cen - 1, item, res);
            item.remove(item.size() - 1);
        }

    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> combine1 = combine.combine(4, 2);
        System.out.println(combine1);
    }
}
