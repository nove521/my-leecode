package com.cx.leecode.In202007;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int len = matrix.length;
        if (len == 0 ){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int len2 = matrix[0].length;
        int count = 0;
        int sum = len * len2;
        int i = 0, j = 0;
        int s1 = 0;
        int s2 = 0;
        while (count < sum){

            for (;count < sum &&  j < len2; j++) {
                res.add(matrix[i][j]);
                count++;
            }
            for (j--,i++; count < sum && i < len; i++){
                res.add(matrix[i][j]);
                count++;
            }
            for(i--,j--;count < sum &&  j >= s1 ; j --){
                res.add(matrix[i][j]);
                count++;
            }
            for (j++,i--;count < sum && i > s2 ; i--) {
                res.add(matrix[i][j]);
                count++;
            }
            s1++;
            s2++;
            i = s1;
            j = s2;
            len = len - 1;
            len2 = len2 - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int [][]nums = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }

        List<Integer> list = spiralOrder.spiralOrder(nums);
        System.out.println(list);
    }
}
