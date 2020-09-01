package com.cx.leecode.In202008;

public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0; i < len; i++) {
            int len2 = matrix[i].length;
            for (int j = 0; j < len2; j++) {
                if (matrix[i][j] == 0){
                    setZero(matrix,i,j,len,len2);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            int len2 = matrix[i].length;
            for (int j = 0; j < len2; j++) {
                if (matrix[i][j] == Integer.MIN_VALUE + 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void setZero(int [][]matrix, int i ,int j, int len ,int len2){
        for (int k = 0; k < len; k++) {
            if (matrix[k][j] != 0){
                matrix[k][j] = Integer.MIN_VALUE + 1;
            }
        }
        for (int k = 0; k < len2; k++) {
            if (matrix[i][k] != 0){
                matrix[i][k] = Integer.MIN_VALUE + 1;
            }
        }
    }

    public static void main(String[] args) {
        SetZeroes setZeroes = new SetZeroes();
        int [][] nums = new int[][]{
                {1,1,1},
                {0,1,1}};
        setZeroes.setZeroes(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }

}
