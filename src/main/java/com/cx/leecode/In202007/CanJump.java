package com.cx.leecode.In202007;

public class CanJump {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (max < i){
                return false;
            }
            max = Math.max(nums[i] + i,max);
            if (max>=len-1) return true;
        }
        return true;
    }

    private boolean isOk(int start, int []nums, int len){
        if (start == len - 1) {
            return true;
        }
        int count = nums[start];
        if (count + start + 1 >= len){
            return true;
        }
        for (int i = 1; i <= count ; i++) {
            boolean ok = isOk(start + i, nums, len);
            if (ok){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        int []nums = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
        boolean ok = canJump.canJump(nums);
        System.out.println(ok);
    }
}
