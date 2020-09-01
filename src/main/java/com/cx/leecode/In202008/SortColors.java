package com.cx.leecode.In202008;

public class SortColors {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int right = len - 1;
        while (right >= 0 && nums[right] == 2) right--;
        int left = 0;
        for (int i = 0; i < len; i++) {
            while (true) {
                if (i > right) {
                    return;
                }
                if (nums[i] == 2) {
                    swap(nums, i, right--);
                    continue;
                }
                if (nums[i] == 0) {
                    swap(nums, left++, i);
                    break;
                }
                if (nums[i] == 1) {
                    break;
                }
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        if (a == b) return;
        nums[a] = nums[a] + nums[b];
        nums[b] = nums[a] - nums[b];
        nums[a] = nums[a] - nums[b];
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = new int[]{2, 2, 0};
        sortColors.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);

        }
    }
}
