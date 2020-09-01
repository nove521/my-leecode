package com.cx.leecode.In202008;

import java.util.LinkedList;

public class LargestRectangleArea {
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int min = heights[i];
            for (int j = i; j < len; j++) {
                if (heights[j] == 0) {
                    break;
                }
                if (heights[j] < min) {
                    min = heights[j];
                }
                int s = min * (j - i + 1);
                max = Math.max(s, max);
            }
        }
        return max;
    }

    public int largestRectangleArea3(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int s = heights[i];
            int lj = i;
            int rj = i;
            int cache = lj - 1;
            while (cache >= 0 && heights[cache] >= s) {
                lj--;
                cache = lj - 1;
            }
            cache = rj + 1;
            while ((cache) < len && heights[cache] >= s) {
                rj++;
                cache = rj + 1;
            }
            max = Math.max(max, (rj - lj + 1) * s);
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        int max = 0;
        len = len + 2;
        int []temp = new int[len];
        System.arraycopy(heights, 0, temp, 1, len - 1 - 1);

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temp[i] < temp[stack.peekFirst()]){
                int x = temp[stack.pollFirst()];
                max = Math.max(max, (i - stack.peekFirst() - 1) * x);
            }
            stack.addFirst(i);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,1,2};
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        System.out.println(largestRectangleArea.largestRectangleArea(nums));
    }
}
