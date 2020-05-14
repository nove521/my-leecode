package com.cx.leecode.In202005;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int L;
        int R;
        int min =  nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len; i++) {
            L = i + 1;
            R = len - 1;
            while ( L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == target){
                    return target;
                }
                if (Math.abs(min - target) >= Math.abs(sum - target)){
                    min = sum;
                }
                if (sum > target){
                    R--;
                }else {
                    L++;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int i = threeSumClosest.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(i); // -3 0 1 2

        i = threeSumClosest.threeSumClosest(new int[]{0, 2, 1, -3}, 1);
        System.out.println(i);

         i = threeSumClosest.threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82);
        System.out.println(i);
    }
}
