package io.huhu.leetcode.n576;

class DP2 implements Code {

    private static final int M = 1000000007;

    private static final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    @Override
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int k = 1; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        dp[i][j][k]++;
                    }
                    if (i == m - 1) {
                        dp[i][j][k]++;
                    }
                    if (j == 0) {
                        dp[i][j][k]++;
                    }
                    if (j == n - 1) {
                        dp[i][j][k]++;
                    }
                    for (int[] dir : DIR) {
                        int _i = i + dir[0], _j = j + dir[1];
                        if (_i >= 0 && _i < m && _j >= 0 && _j < n) {
                            dp[i][j][k] = (dp[i][j][k] + dp[_i][_j][k - 1]) % M;
                        }
                    }
                }
            }
        }
        return dp[startRow][startColumn][maxMove];
    }

}
