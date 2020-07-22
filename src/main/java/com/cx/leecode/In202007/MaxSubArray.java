package com.cx.leecode.In202007;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int []f = new int[len];
        f[0] = nums[0];
        int max = f[0];
        for (int i = 1; i < len; i++) {
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
            max = Math.max(f[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int []nums = {-2,-1};
        int i = maxSubArray.maxSubArray(nums);
        System.out.println(i);
    }
}
