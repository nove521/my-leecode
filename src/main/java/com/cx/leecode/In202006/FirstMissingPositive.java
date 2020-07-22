package com.cx.leecode.In202006;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int []hash = new int[len];
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num <= len && num >= 1){
                hash[num - 1] = 1;
            }
        }
        for (int i = 0; i < len; i++) {
            if (hash[i] == 0){
                return i + 1;
            }
        }
        return len + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (num <= 0){
                nums[i] = len+1;
            }
        }
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (num <= len && num >= 1){
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0){
                return i + 1;
            }
        }
        return len + 1;
    }
}
