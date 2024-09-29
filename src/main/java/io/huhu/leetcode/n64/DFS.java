package io.huhu.leetcode.n64;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (var a : dp) {
            Arrays.fill(a, -1);
        }
        return f(grid, 0, 0, dp);
    }

    private int f(int[][] grid, int i, int j, int[][] dp) {
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            return grid[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        if (i + 1 < grid.length) {
            int a = f(grid, i + 1, j, dp) + grid[i][j];
            ans = Math.min(ans, a);
        }
        if (j + 1 < grid[i].length) {
            int b = f(grid, i, j + 1, dp) + grid[i][j];
            ans = Math.min(ans, b);
        }
        return dp[i][j] = ans;
    }

}
