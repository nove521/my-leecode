package com.cx.leecode.In202008;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int cur = 1;
        int count = 1;
        int per = nums[0];
        for (int i = 1; i < len; i++) {

            if (nums[i] == per){
                if (count >= 2){
                    per = nums[i];
                    continue;
                }
                count++;
            }else {
                if (count > 1){
                    count = 1;
                }
            }

            if (cur < i){
                nums[cur] = nums[i];
            }
            per = nums[i];
            cur++;
        }
        return cur;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int []nums = new int[]{0,0,1,1,1,1,2,3,3};
        int i = removeDuplicates.removeDuplicates(nums);
        System.out.println(i);
    }
}
