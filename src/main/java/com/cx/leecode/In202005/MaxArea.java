package com.cx.leecode.In202005;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArea {
    public int maxArea2(int[] height) {
        int len = height.length;
        int max = -1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int minHeight = Math.min(height[i], height[j]);
                max = Math.max(max, minHeight * (j - i));
            }
        }
        return max;
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = -1;
        while (right > left) {
            int minheith;
            if (height[left] <= height[right]) {
                minheith = height[left];
                left++;
            } else {
                minheith = height[right];
                right--;
            }
            max = Math.max(max, minheith * (right - left + 1));
        }
        return max;
    }
}
