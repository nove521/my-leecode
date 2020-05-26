package com.cx.leecode.In202005;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSum {
    Map<String, String> map = new HashMap<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target) {
                continue;
            }

            int max = nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (max < target) {
                break;
            }

            for (int j = i + 1; j < len - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                min = nums[i] + nums[j] + nums[j + 1] + nums[i + 2];
                if (min > target) {
                    continue;
                }

                max = nums[i] + nums[j] + nums[len - 1] + nums[len - 2];
                if (max < target) {
                    continue;
                }

                int l = j + 1;
                int r = len - 1;

                while (l < r) {

                    if ((nums[i] + nums[j] + nums[l] + nums[r]) == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));

                        l++;
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        r--;
                        while (l < r && nums[r] == nums[r + 1]) r--;
                    }
                    if ((nums[i] + nums[j] + nums[l] + nums[r]) > target) {
                        r--;
                    }
                    if ((nums[i] + nums[j] + nums[l] + nums[r]) < target) {
                        l++;
                    }

                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = new int[]{-3, -1, 0, 2, 4, 5};
        List<List<Integer>> lists = fourSum.fourSum(nums, 0);
        System.out.println(lists);

        nums = new int[]{-2, -1, 0, 0, 1, 2};
        lists = fourSum.fourSum(nums, 0);
        System.out.println(lists);


        nums = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
        lists = fourSum.fourSum(nums, 0);
        System.out.println(lists);
    }
}
