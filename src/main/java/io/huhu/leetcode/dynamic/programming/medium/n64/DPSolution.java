package io.huhu.leetcode.dynamic.programming.medium.n64;

final class DPSolution extends Solution {

    @Override
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] f = new int[n][m];
        f[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            f[i][0] = grid[i][0] + f[i - 1][0];
        }
        for (int j = 1; j < m; j++) {
            f[0][j] = grid[0][j] + f[0][j - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                f[i][j] = grid[i][j] + Math.min(f[i - 1][j], f[i][j - 1]);
            }
        }
        return f[n - 1][m - 1];
    }

}
