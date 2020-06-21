package com.cx.leecode.In202006;

import java.util.Arrays;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int r = nums.length - 1;
        int len = nums.length;
        int[] res = new int[]{-1, -1};
        int leftIndex = findIndex(nums, target, true, 0, len );
        if (leftIndex == nums.length || nums[leftIndex] != target){
            return res;
        }
        res[0] = leftIndex;
        int rightIndex = findIndex(nums, target, false, 0, len ) - 1;
        res[1] = rightIndex;
        return res;
    }

    public int findIndex(int[] nums, int target, boolean isLeft, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (isLeft && nums[mid] == target)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] numx ;
        int[] ints;

        numx = new int[]{5,7,7,8,8,10};
        ints = searchRange.searchRange(numx, 6);
        System.out.println(Arrays.toString(ints));
    }
}
