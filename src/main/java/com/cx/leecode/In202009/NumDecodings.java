package com.cx.leecode.In202009;

import java.time.Duration;
import java.time.Instant;

public class NumDecodings {

    static int count = 0;

    public int numDecodings2(String s) {
        count = 0;
        pp(s,0,s.length());
        return count;
    }

    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];
        if (s.charAt(0) == '0') {
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }
            int jLen = Math.max(i - 1, 0);
            for (int j = i - 1; j >= jLen; j--) {
                String str = s.substring(j, i + 1);
                final int val = Integer.parseInt(str);
                if (val > 9 && val < 27) {
                    if (j - 1 < 0){
                        dp[i] = dp[i] + 1;
                    }else {
                        dp[i] += dp[j - 1];
                    }
                }
            }
        }
        return dp[len - 1];
    }

    private void pp(String s, int start, int len) {
        if (start >= len) {
            count++;
            return;
        }
        int sLen = Math.min(start + 2, len);
        for (int i = start + 1; i <= sLen; i++) {
            String str = s.substring(start, i);
            final int in = Integer.parseInt(str);
            if (in > 0 && in < 27) {
                pp(s, i, len);
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
        Instant start = Instant.now();
        System.out.println(numDecodings.numDecodings("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"));
//        System.out.println(numDecodings.numDecodings("226"));
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());
    }
}
