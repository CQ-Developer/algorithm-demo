package io.huhu.leetcode.dynamic.programming.medium.n64;

final class DPSolution extends Solution {

    @Override
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] f = new int[m];
        f[0] = grid[0][0];
        for (int j = 1; j < m; j++) {
            f[j] = grid[0][j] + f[j - 1];
        }
        for (int i = 1; i < n; i++) {
            f[0] += grid[i][0];
            for (int j = 1; j < m; j++) {
                f[j] = grid[i][j] + Math.min(f[j - 1], f[j]);
            }
        }
        return f[m - 1];
    }

}
