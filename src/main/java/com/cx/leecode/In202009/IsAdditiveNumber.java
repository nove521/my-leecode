package com.cx.leecode.In202009;

public class IsAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        final char[] chars = num.toCharArray();
        int len = chars.length;
        boolean res;
        for (int i = 1; i < len; i++) {
            if (i > 1 && chars[0] == '0'){
                break;
            }
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && chars[i] == '0'){
                    break;
                }
                int ppre = toInt(chars, 0, i);
                int pre = toInt(chars, i, j);
                res = pp(chars, j, pre, ppre);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    private int toInt(char[] chars, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum = sum * 10 + chars[i] - '0';
        }
        return sum;
    }

    private boolean pp(char[] chars, int start, int pre, int ppre) {
        int len = chars.length;
        if (start >= len) {
            return true;
        }
        int sum = ppre + pre;
        int x = 0;
        for (int i = start; i < len; i++) {
            int val = chars[i] - '0';
            x = x * 10 + val;
            if (i > start && chars[start] == '0'){
                return false;
            }
            if (x == sum) {
                return pp(chars, i + 1, sum, pre);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsAdditiveNumber isAdditiveNumber = new IsAdditiveNumber();
        System.out.println(isAdditiveNumber.isAdditiveNumber("0235813"));
    }
}
