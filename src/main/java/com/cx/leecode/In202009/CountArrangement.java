package com.cx.leecode.In202009;

import java.util.Arrays;

public class CountArrangement {
    static int count = 1;

    public int countArrangement(int N) {
        count = 1;
        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = i;
        }
        pp(nums, N, 1);
        return count;
    }

    private void pp(int[] nums, int N, int start) {
        for (int i = start; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if ((i % nums[j] == 0 || nums[j] % i == 0) && (j % nums[i] == 0 || nums[i] % j == 0)) {
                    count++;
                    swap(nums, i, j);
                    System.out.println(Arrays.toString(nums));
                    pp(nums, N, i + 1);
                    swap(nums, i, j);
                }
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
    //4, 6, 1, 2, 5, 3, 7
    //4, 6, 3, 1, 5, 2, 7

    public static void main(String[] args) {
        CountArrangement countArrangement = new CountArrangement();
        System.out.println(countArrangement.countArrangement(7));
    }
}
