package com.cx.leecode.In202006;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        int[][] colHash = new int[9][9];
        int[][] blockHash = new int[9][9];

        for (int i = 0; i < len; i++) {
            int[] rowHash = new int[9];
            int jLen = board[i].length;
            for (int j = 0; j < jLen; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int val = board[i][j] - '0';
                if (rowHash[val - 1] == 1) {
                    return false;
                }
                rowHash[val - 1] = 1;

                if (colHash[j][val - 1] == 1) {
                    return false;
                }
                colHash[j][val - 1] = 1;

                int blockIndex = (i / 3) * 3 + (j / 3);
                if (blockHash[blockIndex][val - 1] == 1) {
                    return false;
                }
                blockHash[blockIndex][val - 1] = 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsValidSudoku isValidSudoku = new IsValidSudoku();
        boolean validSudoku;

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
         validSudoku = isValidSudoku.isValidSudoku(board);
        System.out.println(validSudoku);

        char[][] board2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        validSudoku = isValidSudoku.isValidSudoku(board2);
        System.out.println(validSudoku);

        char[][] board23 = {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        validSudoku = isValidSudoku.isValidSudoku(board23);
        System.out.println(validSudoku);
    }
}
