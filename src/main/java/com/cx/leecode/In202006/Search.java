package com.cx.leecode.In202006;

public class Search {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        return binSearch(nums, target, 0, nums.length - 1);
    }

    public int binSearch(int[] nums, int target, int left, int right) {
        if (right < left) {
            return -1;
        }
        int val = nums[left];
        if (target == val) {
            return left;
        }
        int center = (right - left) / 2 + left;
        int res = -1;
        if (target > val && (res = binSearch(nums, target, left + 1, center)) == -1) {
            return binSearch(nums, target, center + 1, right);
        } else if (target < val && (res = binSearch(nums, target, center + 1, right)) == -1) {
            return binSearch(nums, target, left + 1, center);
        }
        return res;
    }

    public static void main(String[] args) {
        Search search = new Search();

        int[] numx = new int[]{0, 1, 2, 4, 5, 6, 7};
        System.out.println(search.search(numx, 4));

        numx = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search.search(numx, 2));

        numx = new int[]{4, 5, 90, 100, 0, 1, 2};
        System.out.println(search.search(numx, 100));

        numx = new int[]{1};
        System.out.println(search.search(numx, 0));

        numx = new int[]{5, 1, 3};
        System.out.println(search.search(numx, 1));
    }
}
