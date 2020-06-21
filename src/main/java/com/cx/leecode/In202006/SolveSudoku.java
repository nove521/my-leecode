package com.cx.leecode.In202006;

public class SolveSudoku {

    public void solveSudoku(char[][] board) {
        int ccc = 0;
        boolean[][] colHash = new boolean[9][10];
        boolean[][] rowHash = new boolean[9][10];
        boolean[][] blockHash = new boolean[9][10];
        int count = init(board, colHash, rowHash, blockHash);
        int[][] pre = new int[count][2];
        int currentIndex = 0;
        int k = 1;

        int len = board.length;
        for (int i = 0; i < len; i++) {
            int jLen = board[i].length;
            for (int j = 0; j < jLen; j++) {
                ccc ++;
                if (board[i][j] == '.') {

                    for (; k <= 9; k++) {
                        if (fanzhi(i, j, k, colHash, rowHash, blockHash)) {
                            board[i][j] = (char) (k + '0');
                            pre[currentIndex][0] = i;
                            pre[currentIndex][1] = j;
                            currentIndex++;
                            k = 1;
                            break;
                        }
                    }

                    if (k > 9) {
                        int[] preBlock = pre[--currentIndex];
                        i = preBlock[0];
                        j = preBlock[1];
                        k = board[i][j] - '0';
                        clearBlockHash(i, j, k, colHash, rowHash, blockHash);
                        board[i][j] = '.';
                        k++;
                        j--; // 在for循环内需要 减1
                    }
                }
            }
        }
        System.out.println(ccc);
    }

    public boolean fanzhi(int col, int row, int val, boolean[][] colHash, boolean[][] rowHash, boolean[][] blockHash) {
        int blockIndex = (col / 3) * 3 + (row / 3);
        if (colHash[row][val] || rowHash[col][val]  || blockHash[blockIndex][val]) {
            return false;
        }
        colHash[row][val] = true;
        rowHash[col][val] = true;
        blockHash[blockIndex][val] = true;
        return true;
    }

    public void clearBlockHash(int col, int row, int val, boolean[][] colHash, boolean[][] rowHash, boolean[][] blockHash) {
        int blockIndex = (col / 3) * 3 + (row / 3);
        colHash[row][val] = false;
        rowHash[col][val] = false;
        blockHash[blockIndex][val] = false;
    }

    public int init(char[][] board, boolean[][] colHash, boolean[][] rowHash, boolean[][] blockHash) {
        int len = board.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int jLen = board[i].length;
            for (int j = 0; j < jLen; j++) {
                if (board[i][j] != '.') {
                    int x = board[i][j] - '0';
                    colHash[j][x] = true;
                    rowHash[i][x] = true;
                    int blockIndex = (i / 3) * 3 + (j / 3);
                    blockHash[blockIndex][x] = true;
                } else {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] nums = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        SolveSudoku solveSudoku = new SolveSudoku();
        solveSudoku.solveSudoku(nums);

        nums = new char[][]{{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '2', '.', '1', '.', '9', '.', '.', '.'}, {'.', '.', '7', '.', '.', '.', '2', '4', '.'}, {'.', '6', '4', '.', '1', '.', '5', '9', '.'}, {'.', '9', '8', '.', '.', '.', '3', '.', '.'}, {'.', '.', '.', '8', '.', '3', '.', '2', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '6'}, {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        print(nums);
        solveSudoku.solveSudoku(nums);
        print(nums);
    }

    private static void print(char[][] nums) {
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
