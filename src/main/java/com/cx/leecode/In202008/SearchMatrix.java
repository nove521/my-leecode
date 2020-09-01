package com.cx.leecode.In202008;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        if (matrix[0].length == 0){
            return false;
        }
        int search = search(matrix, target, 0, matrix.length - 1);
        if (search < 0){
            return false;
        }

        if (matrix[search][0] == target || matrix[search][matrix[search].length - 1] == target){
            return true;
        }
        return search2(matrix,target,search,0, matrix[search].length - 1) > 0;
    }

    private int search(int[][] matrix, int target, int top , int bottom) {
        if (top > bottom) {
            return bottom;
        }
        int mid = top + (bottom - top) / 2;
        int val = matrix[mid][0];
        if (target == val){
            return mid;
        }
        if (target > val){
            if (target > matrix[mid][matrix[mid].length - 1]){
                top = mid + 1;
            }else {
                return mid;
            }
        }else {
            bottom = mid - 1;
        }
        return search(matrix, target, top,bottom);
    }

    private int search2(int[][] matrix, int target, int i, int left ,int right) {
        if (left > right){
            return -1;
        }
        int mid = left + (right - left) / 2;
        int val = matrix[i][mid];
        if (target == val){
            return mid;
        }

        if (target > val){
            left = mid + 1;
        }else {
            right = mid - 1;
        }
        return search2(matrix, target, i, left, right);
    }

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        int [][]nums = new int[][]{
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        nums = new int[][]{
                {1}
        };
        System.out.println(searchMatrix.searchMatrix(nums, 0));
    }
}
