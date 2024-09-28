package io.huhu.leetcode.n62;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (var a : dp) {
            Arrays.fill(a, -1);
        }
        return f(m, n, 1, 1, dp);
    }

    private int f(int m, int n, int i, int j, int[][] dp) {
        if (i == m && j == n) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if (i < m) {
            ans += f(m, n, i + 1, j, dp);
        }
        if (j < n) {
            ans += f(m, n, i, j + 1, dp);
        }
        return dp[i][j] = ans;
    }

}
