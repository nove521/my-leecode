package com.cx.leecode.In202006;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (l == nums.length) || nums[l] > target ? l : l + 1;
    }

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int[] nums;
        int i;
        nums = new int[]{1, 3, 5, 6};
        i = searchInsert.searchInsert(nums, 5);
        System.out.println(i);

        nums = new int[]{1, 3, 5, 6};
        i = searchInsert.searchInsert(nums, 2);
        System.out.println(i);

        i = searchInsert.searchInsert(nums, 7);
        System.out.println(i);

        i = searchInsert.searchInsert(nums, 0);
        System.out.println(i);

        nums = new int[]{1, 3};
        i = searchInsert.searchInsert(nums, 2);
        System.out.println(i);

        nums = new int[]{1, 3, 5, 6};
        i = searchInsert.searchInsert(nums, 2);
        System.out.println(i);
    }
}
