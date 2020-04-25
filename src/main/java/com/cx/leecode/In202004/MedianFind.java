package com.cx.leecode.In202004;

import java.util.Arrays;
import java.util.Objects;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode+cn.com/problems/median+of+two+sorted+arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianFind {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        // 为了减少条件判断奇数偶数。 直接采用 2次调用 递归。
        // 一开始没想到还可以这样。 导致出现 奇数偶数个判断条件很多，这里直接简化了
        // 就是 如果是奇数个， 加1 除2 。结果是不会变的。相当于求了2次。这里可以对奇数个优化， 减少一次递归。
        // 如果是偶数个。 加1 除2 .结果会 加1 。 就可以求出 原本 mid 个数的后一位。
        int mid1 = (len + 1) / 2 ;
        int mid2 = (len + 2) / 2 ;

        return (getMedian(nums1, nums2, mid1, 0, 0) + getMedian(nums1, nums2, mid2 , 0, 0)) / 2.0;
    }

    /**
     * 求第 mid 个数
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @param mid 要求的第几个数
     * @param nums1Left 数组1 左边界移动后坐标
     * @param nums2Left 数组2 左边界移动后的坐标
     * @return 第 mid 个数
     */
    private int getMedian(int[] nums1, int[] nums2, int mid, int nums1Left, int nums2Left) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        // 判断 数组1 实际长度，根据左边界移动后的 数组长度判断
        // 如果 已经超过，说明数组1 不包含我们要的值 就可以直接在 数组2 定位到
        // 一开始这部放在后面，导致条件判断很多，直接移到头部减少了一些判断代码
        if (len1 - nums1Left == 0){
            return nums2[nums2Left + mid - 1];
        }
        // 判断 数组2 实际长度，根据左边界移动后的 数组长度判断
        if (len2 - nums2Left == 0){
            return nums1[nums1Left + mid - 1];
        }

        // 判断第几个书，如果只有1个，那么直接根据 2个数组左边界判断。
        // 这时候保证2个数组都是不为空的
        if (mid <= 1){
            return Math.min(nums1[nums1Left],nums2[nums2Left]);
        }
        //二分求 各个数组的中间点。
        int midTomid = mid / 2;

        // 计算 各个数组中间点 应该取的下标
        int index1 = midTomid + nums1Left - 1;
        int index2 = midTomid + nums2Left - 1;

        // 如果超过数组的长度。则直接取 数组最后一位。
        // 这里保证只会取到一次，因为之后 左边界会右移 。保证不会一直在末尾死循环
        if (index1 >= len1) {
            index1 = len1 - 1;
        }else if (index2 >= len2) {
            index2 = len2 - 1;
        }

        // 判断2个数组临界值 （中间值） 的大小。
        if (nums1[index1] > nums2[index2]) {
            // 在这里对求的第几位 扣除。 就是 扣除掉 左边界移动后，删去的个数。
            mid = mid - index2 - 1 + nums2Left ;
            // 左边界 在临界值上右移一位
            nums2Left = index2 + 1;
        } else {
            mid = mid - index1 - 1 + nums1Left;
            nums1Left = index1 + 1;
        }

        return getMedian(nums1, nums2, mid, nums1Left, nums2Left);
    }


    public static void main(String[] args) {
        MedianFind medianFind = new MedianFind();

        int[] nums1 = new int[]{1, 2, 3, 4};
        int[] nums2 = new int[]{1, 2, 3, 4};
        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        printMsg(medianFind.findMedianSortedArrays(nums1, nums2), 2.5, nums1, nums2);
    }

    private static void printMsg(double val, double expect, int[] nums1, int[] nums2) {
        System.out.println("数组1：" + Arrays.toString(nums1));
        System.out.println("数组2：" + Arrays.toString(nums2));
        System.out.println("计算的中位数是：" + val);
    }

}
