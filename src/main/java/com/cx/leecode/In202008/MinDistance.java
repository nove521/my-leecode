package com.cx.leecode.In202008;

/**
 * dp[i][j]  表示 word1 从 0-i 转换成 word2 0-j 的次数
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int len = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len + 1][len2 + 1];

        char[] chars = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        for (int i = 0; i < len + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < len2 + 1; i++) {
            dp[0][i] = i;
        }
        len ++;
        len2 ++;
        for (int i = 1; i < len ; i++) {
            char w1 = chars[i - 1];
            for (int j = 1; j < len2 ; j++) {
                char w2 = chars2[j - 1];
                if (w1 == w2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[len-1][len2-1];
    }

    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        System.out.println(minDistance.minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));
    }
}
