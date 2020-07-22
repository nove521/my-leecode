package com.cx.leecode.In202007;

import java.util.Arrays;

public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        if (len == 0) return new int[][]{newInterval};

        int start = binarySearch(intervals, newInterval[0], 0, len - 1);
        int end = binarySearch(intervals, newInterval[1], 0, len - 1);

        int[][] res = new int[len + 1][2];
        int k = 0;
        for (int i = 0; i < start; i++) {
            res[k++] = intervals[i];
        }

        if (inQujian(intervals[start], newInterval[1])) {

            res[k++] = intervals[start];
            add(res, intervals, end + 1, k, len);

            return Arrays.copyOf(res,k);
        }

        if (!inQujian(intervals[start], newInterval[0]) && !inQujian(intervals[end], newInterval[1])) {
            res[k++] = intervals[start];

            res[k++] = newInterval;
        }

        if (inQujian(intervals[start], newInterval[0]) && inQujian(intervals[end], newInterval[1])) {
            res[k][0] = intervals[start][0];
            res[k++][1] = intervals[end][1];
        }

        if (inQujian(intervals[start], newInterval[0]) && !inQujian(intervals[end], newInterval[1])) {
            res[k][0] = intervals[start][0];
            res[k++][1] = newInterval[1];

            res[k++] = intervals[end];
        }

        if (!inQujian(intervals[start], newInterval[0]) && inQujian(intervals[end], newInterval[1])) {

            res[k++] = intervals[start];

            res[k][0] = newInterval[0];
            res[k++][1] = intervals[end][1];
        }

        add(res, intervals, end + 1, k, len);

        return Arrays.copyOf(res,k);

    }

    public void add(int[][] res, int[][] intervals, int i, int k, int len) {
        for (; i < len; i++) {
            res[k++] = intervals[i];
        }

    }

    public boolean inQujian(int[] qujian, int val) {
        if (qujian[0] <= val && qujian[1] >= val) {
            return true;
        }
        return false;
    }

    public int binarySearch(int[][] arr, int search, int left, int right) {
        if (left > right) {
            return right;
        }

        int mid = (right - left) / 2 + left;

        if (search > arr[mid][0]) {
            left = mid + 1;
            return binarySearch(arr, search, left, right);
        } else if (search < arr[mid][0]) {
            right = mid - 1;
            return binarySearch(arr, search, left, right);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {

        int[][] nums = new int[][]{{1, 3}};

        Insert insert = new Insert();
        int[][] res = insert.insert(nums, new int[]{1, 4});

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }

    }

}
