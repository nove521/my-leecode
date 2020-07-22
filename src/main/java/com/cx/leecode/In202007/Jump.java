package com.cx.leecode.In202007;

public class Jump {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return 0;
        }
        int[] map = new int[len];
        int last = 1;
        for (int i = 0; i < len; i++) {
            int count = nums[i];
            if (count + i < last){
                continue;
            }
            int k = last;
            int s = map[i] + 1;
            if (count + i >= len - 1){
                return s;
            }

            while (k <= (count + i)) {
                if (map[k] == 0){
                    map[k] = s;
                }
                k++;
            }
            last = k;
        }
        return map[len - 1];
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        int []nums = new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        int jump1 = jump.jump(nums);
        System.out.println(jump1);
    }
}
