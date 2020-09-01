package com.cx.leecode.In202008;

import java.util.LinkedList;

public class MaximalRectangle {

    static int[] newNums;
    static LinkedList<Integer> stack ;

    public int maximalRectangle(char[][] matrix) {

        int len = matrix.length;
        if (len == 0) {
            return 0;
        }
        int max = 0;
        int[] map = new int[matrix[0].length];
        newNums = new int[matrix[0].length + 2];
        stack = new LinkedList<>();

        for (char[] chars : matrix) {
            int len2 = chars.length;
            for (int j = 0; j < len2; j++) {
                if (chars[j] == '0'){
                    map[j] = 0;
                }else {
                    map[j] = map[j] + (chars[j] - '0');
                }
            }
            max = Math.max(max, fun(map));
        }
        return max;
    }

    private int fun(int[] nums) {
        int len = nums.length;
        len = len + 2;
        newNums[0] = 0;
        System.arraycopy(nums, 0, newNums, 1, len - 1 - 1);
        int max = 0;
        stack.clear();

        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && newNums[i] < newNums[stack.peekFirst()]) {

                int h = newNums[stack.pollFirst()];
                max = Math.max(max, (i - stack.peekFirst() - 1) * h);

            }
            stack.addFirst(i);
        }

        return max;
    }

    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        char[][] nums = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

//        nums = new char[][]{
//                {'0','1'},
//                {'1','0'},
//        };

        System.out.println(maximalRectangle.maximalRectangle(nums));
    }
}
