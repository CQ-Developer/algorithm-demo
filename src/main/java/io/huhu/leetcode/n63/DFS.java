package io.huhu.leetcode.n63;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int [][] dp = new int[m][n];
        for (var a : dp) {
            Arrays.fill(a, -1);
        }
        return f(obstacleGrid, m, n, 0, 0, dp);
    }

    private int f(int[][] grid, int m, int n, int i, int j, int[][] dp) {
        if (grid[i][j] == 1) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if (i + 1 < m) {
            ans += f(grid, m, n, i + 1, j, dp);
        }
        if (j + 1 < n) {
            ans += f(grid, m, n, i, j + 1, dp);
        }
        return dp[i][j] = ans;
    }

}
