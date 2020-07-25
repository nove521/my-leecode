package com.cx.leecode.In202007;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[n][m];
        int pp = pp(map, 0, 0, n, m);
        return pp;
    }

    private int pp(int[][] map, int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        int x = 0;
        if ((i + 1) < n && map[i + 1][j] == 0) {
            int c = pp(map, i + 1, j, n, m);
            x += c;
            map[i + 1][j] = c;
        } else if ((i + 1) < n) {
            x += map[i + 1][j];
        }
        if ((j + 1) < m && map[i][j + 1] == 0) {
            int c = pp(map, i, j + 1, n, m);
            x += c;
            map[i][j + 1] = c;
        } else if ((j + 1) < m) {
            x += map[i][j + 1];
        }
        return x;
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(7, 3));
    }

}
