package com.cx.leecode.In202008;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class Search {

    static int x = 0;

    public boolean search(int[] nums, int target) {
        if (nums.length == 0){
            return false;
        }
        return binSearch2(nums, target, 0, nums.length - 1);
    }

    private boolean binSearch2(int[] nums, int target, int left, int rifht) {
        int mid;
        while (true){
            if (left > rifht) {
                return false;
            }
            mid = left + (rifht - left) / 2;
            if (target == nums[mid]) {
                return true;
            }

            if (nums[left] == nums[mid]) {
                left++;
            }else {
                break;
            }
        }

        if (nums[mid] > nums[left]) {

            if (target >= nums[left] && target < nums[mid]){
                return binSearch2(nums,target,left,mid - 1);
            }else {
                return binSearch2(nums,target,mid + 1,rifht);
            }
        }else {
            if (target <= nums[rifht] && target > nums[mid]){
                return binSearch2(nums,target,mid + 1,rifht);
            }else {
                return binSearch2(nums,target,left,mid - 1);
            }
        }
    }

    private boolean binSearch3(int[] nums, int target, int left, int rifht) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段
            if (nums[mid] >= nums[lo]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }


    private boolean binSearch(int[] nums, int target, int left, int rifht) {
        x++;
        if (left > rifht) {
            return false;
        }

        if (target == nums[left]) {
            return true;
        }

        int mid = left + (rifht - left) / 2;

        if (nums[mid] > nums[left]) {
            if (binSearch(nums, target, mid + 1, rifht)) {
                return true;
            }
            return binSearch(nums, target, left + 1, mid);
        } else {
            if (binSearch(nums, target, left + 1, mid)) {
                return true;
            }
            return binSearch(nums, target, mid + 1, rifht);
        }
    }


    public static void main(String[] args) {
        Search search = new Search();
        int[] nums = new int[]{1};
        System.out.println(search.search(nums, 0));
        System.out.println(nums.length);
        System.out.println(x);
    }
}
