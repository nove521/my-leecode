package com.cx.leecode.In202008;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            int len = res.size();
            for (int j = len - 1; j >= 0; j--) {
                res.add( head + res.get(j) );
            }
            head <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.grayCode(3));
    }
}
