package io.huhu.leetcode.n931;

import io.huhu.AC;

import java.util.Arrays;

@AC
class DepthFirstSearch implements Code {

    @Override
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE, n = matrix.length;
        int[][] dp = new int[n][n];
        for (int[] _dp : dp) {
            Arrays.fill(_dp, ans);
        }
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, f(matrix, n, 0, j, dp));
        }
        return ans;
    }

    private int f(int[][] matrix, int n, int i, int j, int[][] dp) {
        if (i == n) {
            return 0;
        }
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }
        int ans = f(matrix, n, i + 1, j, dp);
        if (j - 1 >= 0) {
            ans = Math.min(ans, f(matrix, n, i + 1, j - 1, dp));
        }
        if (j + 1 < n) {
            ans = Math.min(ans, f(matrix, n, i + 1, j + 1, dp));
        }
        return dp[i][j] = ans + matrix[i][j];
    }

}
