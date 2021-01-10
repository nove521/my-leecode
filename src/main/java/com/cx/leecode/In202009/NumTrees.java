package com.cx.leecode.In202009;

public class NumTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += (dp[i - j] * dp[j - 1]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        NumTrees numTrees = new NumTrees();
        System.out.println(numTrees.numTrees(3));
        System.out.println(numTrees.numTrees(4));
        System.out.println(numTrees.numTrees(5));
        System.out.println(numTrees.numTrees(10));
    }
}
