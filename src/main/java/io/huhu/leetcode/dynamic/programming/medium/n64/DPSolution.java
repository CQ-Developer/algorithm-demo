package io.huhu.leetcode.dynamic.programming.medium.n64;

final class DPSolution extends Solution {

    @Override
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] f = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = grid[i][j];
                } else if (i - 1 < 0) {
                    f[i][j] = grid[i][j] + f[i][j - 1];
                } else if (j - 1 < 0) {
                    f[i][j] = grid[i][j] + f[i - 1][j];
                } else {
                    f[i][j] = grid[i][j] + Math.min(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[n - 1][m - 1];
    }

}
