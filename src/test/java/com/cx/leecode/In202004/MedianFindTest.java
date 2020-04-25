package com.cx.leecode.In202004;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MedianFindTest extends TestCase {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testFindMedianSortedArrays() {
        MedianFind medianFind = new MedianFind();


        int[] nums1 = new int[]{1, 2, 3, 4};
        int[] nums2 = new int[]{1, 2, 3, 4};
        printMsg(medianFind.findMedianSortedArrays(nums1, nums2), 2.5, nums1, nums2);

        nums1 = new int[]{2, 3};
        nums2 = new int[]{1, 4};
        printMsg(medianFind.findMedianSortedArrays(nums1, nums2), 2.5, nums1, nums2);

        nums1 = new int[]{1, 3};
        nums2 = new int[]{2};
        printMsg(medianFind.findMedianSortedArrays(nums1, nums2), 2.0, nums1, nums2);

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        printMsg(medianFind.findMedianSortedArrays(nums1, nums2), 2.5, nums1, nums2);

        nums1 = new int[]{1, 2, 3};
        nums2 = new int[]{5, 6, 7, 10};
        printMsg(medianFind.findMedianSortedArrays(nums1, nums2), 5.0, nums1, nums2);

        nums1 = new int[]{3};
        nums2 = new int[]{-2, -1};
        printMsg(medianFind.findMedianSortedArrays(nums1, nums2), -1.0, nums1, nums2);

        nums1 = new int[]{1};
        nums2 = new int[]{1};
        printMsg(medianFind.findMedianSortedArrays(nums1, nums2), 1.0, nums1, nums2);

        nums1 = new int[]{1};
        nums2 = new int[]{2};
        printMsg(medianFind.findMedianSortedArrays(nums1, nums2), 1.5, nums1, nums2);

        nums1 = new int[]{};
        nums2 = new int[]{2,3};
        printMsg(medianFind.findMedianSortedArrays(nums1, nums2), 2.5, nums1, nums2);

        nums1 = new int[]{};
        nums2 = new int[]{4,5,6,8,9};
        printMsg(medianFind.findMedianSortedArrays(nums1, nums2), 6.0, nums1, nums2);
    }

    private void printMsg(double val, double expect, int[] nums1, int[] nums2) {
        System.out.println("数组1：" + Arrays.toString(nums1));
        System.out.println("数组2：" + Arrays.toString(nums2));
        System.out.println("计算的中位数是：" + val);
        assertEquals(expect, val);
    }
}