package com.cx.leecode.In202007;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int len = obstacleGrid.length;
        int len2 = obstacleGrid[0].length;
        int[][] dp = new int[len][len2];
        for (int j = 0; j < len2; j++) {
            if (obstacleGrid[0][j] == 1)
                break;
            dp[0][j] = 1;
        }
        for (int j = 0; j < len; j++) {
            if (obstacleGrid[j][0] == 1)
                break;
            dp[j][0] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len2; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[len - 1][len2 - 1];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1},
                {0}
        };


        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        int i = uniquePathsWithObstacles.uniquePathsWithObstacles(nums);
        System.out.println(i);
    }
}
