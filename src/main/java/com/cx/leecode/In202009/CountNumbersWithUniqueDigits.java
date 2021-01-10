package com.cx.leecode.In202009;

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        return dfs(Math.min(10, n), 0, new boolean[10]);
    }
    private int dfs(int n, int idx, boolean[] used) {
        int count = 0;
        if (idx != n) {
            for (int i = 0; i < 10; i++) {
                //多位数时，第一个数字不能为0
                if (i == 0 && n > 1 && idx == 1) {
                    continue;
                }
                //不能使用用过的数字
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                count += dfs(n, idx + 1, used) + 1;
                used[i] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountNumbersWithUniqueDigits countNumbersWithUniqueDigits = new CountNumbersWithUniqueDigits();
        System.out.println(countNumbersWithUniqueDigits.countNumbersWithUniqueDigits(3));
    }
}
