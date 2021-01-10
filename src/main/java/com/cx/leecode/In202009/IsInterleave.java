package com.cx.leecode.In202009;

public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int s3Len = s3.length();
        if (s3Len != s1Len + s2Len) {
            return false;
        }
        final char[] s1List = s1.toCharArray();
        final char[] s2List = s2.toCharArray();
        final char[] s3Chars = s3.toCharArray();

        boolean[][] dp = new boolean[s1Len + 1][s2Len + 1];
        dp[0][0] = true;
        int p = 0;
            for (int j = 0;  j <= s1Len; j++) {
                for (int k = 0;   k <= s2Len; k++) {
                    p = j + k - 1;
                    if (j - 1 >= 0 && s3Chars[p] == s1List[j - 1]) {
                        dp[j][k] = dp[j - 1][k];
                    }
                    if (!dp[j][k] && k - 1 >= 0 && s3Chars[p] == s2List[k - 1]) {
                        dp[j][k] = dp[j][k - 1];
                    }
                }
            }
        return dp[s1Len][s2Len];
    }

    public static void main(String[] args) {
        IsInterleave isInterleave = new IsInterleave();
        System.out.println(isInterleave.isInterleave("ab", "bc", "bbac"));
        System.out.println(isInterleave.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(isInterleave.isInterleave("ab", "bc", "bbac"));
    }
}
