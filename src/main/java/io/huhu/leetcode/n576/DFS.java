package io.huhu.leetcode.n576;

import java.util.Arrays;

class DFS implements Code {

    private static final int M = 1000000007;

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
            ans += f(m, n, s - 1, i + 1, j, dp);
            ans %= M;
            ans += f(m, n, s - 1, i - 1, j, dp);
            ans %= M;
            ans += f(m, n, s - 1, i, j + 1, dp);
            ans %= M;
            ans += f(m, n, s - 1, i, j - 1, dp);
            ans %= M;
        }
        return dp[i][j][s] = ans;
    }

}
