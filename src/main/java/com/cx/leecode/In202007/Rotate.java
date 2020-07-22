package com.cx.leecode.In202007;

public class Rotate {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            int lenJ = len - i - 1;
            for (int j = 0; j < lenJ; j++) {
                change1(j, i, matrix);
            }
        }
        int lenU = len / 2;
        for (int i = 0; i < lenU; i++) {
            for (int j = 0; j < len; j++) {
                change2(i, j, matrix);
            }
        }
    }

    public static void change1(int x, int y, int[][] nums) {
        int len = nums.length;
        int x1 = len - y - 1;
        int y1 = len - x - 1;
        int swap = nums[x][y];
        nums[x][y] = nums[x1][y1];
        nums[x1][y1] = swap;
    }

    public static void change2(int x, int y, int[][] nums) {
        int len = nums.length;
        int x1 = len - x - 1;
        int y1 = y;
        int swap = nums[x][y];
        nums[x][y] = nums[x1][y1];
        nums[x1][y1] = swap;
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int [][]n = new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        print(n);
        rotate.rotate(n);
        print(n);
    }

    private static void print(int [][]nums){
        System.out.println();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
