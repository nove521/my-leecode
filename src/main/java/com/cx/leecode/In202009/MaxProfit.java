package com.cx.leecode.In202009;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;

        int[] dp = new int[len + 1];

        for (int i = 2; i <= len; i++) {
            for (int j = 1; j < i; j++) {
                int x = prices[i - 1] - prices[j - 1];
                if (x > 0) {
                    dp[i] = Math.max(dp[j - 1] + x, dp[i]);
                } else {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] nums = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit.maxProfit(nums));
    }
}
