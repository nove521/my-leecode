package com.cx.leecode.In202007;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int len = n;
        int c = 1;
        int [][]res = new int[n][n];
        while ( c <= (n*n)){
            int i = (n - len);
            int j = (n - len);
            for (; j < len; j++) {
                res[i][j] = c;
                c++;
            }

            for (j--,i++; i < len; i ++){
                res[i][j] = c;
                c++;
            }

            for (i--,j--; j >=(n - len);j--){
                res[i][j] = c;
                c++;
            }


            for (j++,i--; i > (n - len); i--){
                res[i][j] = c;
                c++;
            }

            len--;
        }
        return res;
    }

    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        int[][] ints = generateMatrix.generateMatrix(2);

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }
}
