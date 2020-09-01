package com.cx.leecode.In202007;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int sum = 0;
        int i = len - 1;
        while (i >= 0){
            sum = digits[i] + 1;
            digits[i] = sum % 10;
            i--;
            if (sum <= 9){
                return digits;
            }
        }

        if (sum > 9){
            int []res = new int[len + 1];
            res[0] = 1;
            for (int j = 1; j < len + 1; j++) {
                res[j] = digits[j - 1];
            }
            return res;
        }

        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int []nums = new int[]{1,1,1};
        int[] ints = plusOne.plusOne(nums);
        System.out.println(Arrays.toString(ints));
    }
}
