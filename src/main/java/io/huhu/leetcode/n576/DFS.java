package io.huhu.leetcode.n576;

import java.util.Arrays;

class DFS implements Code {

    private static final int M = 1000000007;

    private static final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    @Override
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return f(m, n, maxMove, startRow, startColumn, dp);
    }

    private int f(int m, int n, int s, int i, int j, int[][][] dp) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        if (dp[i][j][s] != -1) {
            return dp[i][j][s];
        }
        int ans = 0;
        if (s != 0) {
            for (int[] d : DIR) {
                ans = (ans + f(m, n, s - 1, i + d[0], j + d[1], dp)) % M;
            }
        }
        return dp[i][j][s] = ans;
    }

}
