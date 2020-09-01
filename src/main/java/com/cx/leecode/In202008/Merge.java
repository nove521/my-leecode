package com.cx.leecode.In202008;

import java.util.Arrays;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int len = m + n;
        m--;
        n--;
        for (int i = len - 1; i >= 0; i--) {
            if (m >= 0 && nums1[m] > nums2[n]) {
                nums1[i] = nums1[m--];
            } else {
                nums1[i] = nums2[n--];
            }
            if (n < 0) {
                while (m >= 0) nums1[--i] = nums1[m--];
                return;
            }
        }
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,5,6};
        merge.merge(nums1, 3, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }
}
