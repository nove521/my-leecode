package com.cx.leecode.In202007;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {

    int[] hashX;
    int[] hashY;
    int[] hashXi;
    int[] hashYi;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        hashX = new int[n];
        hashY = new int[n];
        hashXi = new int[2 * n - 1];
        hashYi = new int[2 * n - 1];
        int[] xxxx = new int[n];

        int j = 0;
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (; j < n; j++) {
                if (isHave(i, j, n)) {
                    if (j == n - 1) {
                        i--;
                        do {
                            if (i < 0)
                                return res;
                            j = hashX[i] - 1;
                            initHash(i, j, n);
                            map[i][j] = 0;
                            j = j + 1;
                            i--;
                        } while (j >= n);
                        break;
                    } else {
                        continue;
                    }
                }
                map[i][j] = 1;
                setHash(i, j, n);
                xxxx[i] = j + 1;

                if (i == n - 1) {
                    setRes(n, map, res);
                    initHash(i, j, n);
                    map[i][j] = 0;

                    i--;
                    do {
                        if (i < 0) return res;
                        j = hashX[i] - 1;
                        initHash(i, j, n);
                        map[i][j] = 0;
                        j = j + 1;
                        i--;
                    } while (j >= n);

                } else {
                    j = 0;

                }
                break;
            }

        }
        return res;
    }

    private void setHash(int i, int j, int n) {
        hashX[i] = j + 1;
        hashY[j] = 1;
        hashXi[n - i + j - 1] = 1;
        hashYi[i + j] = 1;
    }

    private void initHash(int i, int j, int n) {
        hashX[i] = 0;
        hashY[j] = 0;
        hashXi[n - i + j - 1] = 0;
        hashYi[i + j] = 0;
    }

    private boolean isHave(int i, int j, int n) {
        if (hashX[i] >= 1) {
            return true;
        }
        if (hashY[j] >= 1) {
            return true;
        }
        if (hashXi[n - i + j - 1] >= 1) {
            return true;
        }
        if (hashYi[i + j] >= 1) {
            return true;
        }
        return false;
    }

    private void setRes(int n, int[][] map, List<List<String>> res) {
        List<String> item = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(n);
            for (int k = 0; k < n; k++) {
                if (map[i][k] == 1) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            item.add(sb.toString());
        }
        res.add(item);
    }



    public static void main(String[] args) throws IOException {
        class Xxxxxx extends FileInputStream{

            Xxxxxx(String f) throws FileNotFoundException {
                super(f);
            }

            public int read() throws IOException {
                throw new IOException("sss");
            }

            public void close() throws IOException {
                throw new IOException("close");
            }
        }
        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> lists = solveNQueens.solveNQueens(4);
        System.out.println(lists);
        Xxxxxx inputStream  = new Xxxxxx("pom.xml");
        try {
            OutputStream outputStream = new FileOutputStream("xxx.xml");
            try {
                int read = inputStream.read();
                outputStream.write(read);
            }finally {
                outputStream.close();
            }

        } finally {
            inputStream.close();
        }
    }
}
