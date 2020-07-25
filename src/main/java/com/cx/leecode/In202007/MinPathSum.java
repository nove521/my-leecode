package com.cx.leecode.In202007;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int len = grid.length;
        int len2 = grid[0].length;
        int[][] dp = new int[len][len2];
        dp[0][0] = grid[0][0];
        for (int j = 1; j < len2; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];

        }
        for (int j = 1; j < len; j++) {
            dp[j][0] = grid[j][0] + dp[j - 1][0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len2; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j -1]);
            }
        }
        return dp[len - 1][len2 - 1];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,2,},
                {5,6,},
                {1,1,},
        };

        MinPathSum minPathSum = new MinPathSum();
        int i = minPathSum.minPathSum(nums);
        System.out.println(i);
    }
}
