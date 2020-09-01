package com.cx.leecode.In202008;

public class IsScramble {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        int len2 = s2.length();

        if (len != len2) {
            return false;
        }

        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();

        boolean[][][] dp = new boolean[len][len][len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j][1] = chs1[i] == chs2[j];
            }
        }

        for (int k = 2; k <= len; k++) {

            for (int i = 0; i <= len - k; i++) {
                for (int j = 0; j <= len - k; j++) {

                    for (int w = 1; w <= k - 1; w++) {

                        if (dp[i][j][w] && dp[i + w][j + w][k - w]){
                            dp[i][j][k] = true;
                            break;
                        }
                        if (dp[i][j + k - w][w] && dp[i + w][j][k - w]){
                            dp[i][j][k] = true;
                            break;
                        }
                    }

                }
            }

        }

        return dp[0][0][len];
    }

    public static void main(String[] args) {
        IsScramble isScramble = new IsScramble();
        System.out.println(isScramble.isScramble("great", "rgeat"));
    }
}
