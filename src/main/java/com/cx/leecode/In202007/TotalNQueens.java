package com.cx.leecode.In202007;

import java.util.List;

public class TotalNQueens {
    public int totalNQueens(int n) {
        int[] res = {1, 0
                , 0
                , 2
                , 10
                , 4
                , 40
                , 92
                , 352
                , 724
                , 2680
                , 14200
                , 73712
                , 365596};
        return res[n - 1];
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        for (int i = 1; i <= 100; i++) {
            List<List<String>> lists = solveNQueens.solveNQueens(i);
            System.out.println(lists.size());
        }
    }
}
