package com.cx.leecode.In202008;

public class ClimbStairs {
    public int climbStairs(int n) {
        int []dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] =  dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(2));
        System.out.println(climbStairs.climbStairs(3));
        System.out.println(climbStairs.climbStairs(4));
    }
}
