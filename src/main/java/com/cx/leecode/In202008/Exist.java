package com.cx.leecode.In202008;

public class Exist {
    public boolean exist(char[][] board, String word) {
        int len = board.length;
        if (len == 0){
            return false;
        }
        char[] chars = word.toCharArray();
        int[][] hash = new int[len][board[0].length];
        for (int i = 0; i < len; i++) {
            int len2 = board[i].length;
            for (int j = 0; j < len2; j++) {
                if (board[i][j] == chars[0]) {
                    if (find(board, chars, hash, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, char[] word, int[][] hash, int start, int i, int j) {
        if (start == word.length - 1) {
            return board[i][j] == word[start];
        }

        if (board[i][j] != word[start]) {
            return false;
        }
        int len = board.length;
        hash[i][j] = 1;
        if (i + 1 < len && hash[i + 1][j] == 0) {
            if (find(board, word, hash, start + 1, i + 1, j)) {
                return true;
            }
        }
        if (i - 1 >= 0 && hash[i - 1][j] == 0) {
            if (find(board, word, hash, start + 1, i - 1, j)) {
                return true;
            }
        }

        if (j - 1 >= 0 && hash[i][j - 1] == 0) {
            if (find(board, word, hash, start + 1, i, j - 1)) {
                return true;
            }
        }

        if (j + 1 < board[i].length && hash[i][j + 1] == 0) {
            if (find(board, word, hash, start + 1, i, j + 1)) {
                return true;
            }
        }
        hash[i][j] = 0;
        return false;
    }

    public static void main(String[] args) {
        Exist exist = new Exist();
        char[][] borad = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        /*{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };*/

        boolean b = exist.exist(borad, "ABCESEEEFS");
        System.out.println(b);
    }
}
