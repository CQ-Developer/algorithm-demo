package io.huhu.leetcode.dynamic.programming.hard.n2435;

final class DP implements Solution {

    @Override
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] f = new int[m][n][k];
        f[m - 1][n - 1][grid[m - 1][n - 1] % k] = 1;
        for (int i = m - 2, j = n - 1; i >= 0; i--) {
            for (int h = 0; h < k; h++) {
                f[i][j][h] = f[i + 1][j][(k + h - grid[i][j] % k) % k];
            }
        }
        for (int i = m - 1, j = n - 2; j >= 0; j--) {
            for (int h = 0; h < k; h++) {
                f[i][j][h] = f[i][j + 1][(k + h - grid[i][j] % k) % k];
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                for (int h = 0; h < k; h++) {
                    int r = (k + h - grid[i][j] % k) % k;
                    f[i][j][h] = (f[i + 1][j][r] + f[i][j + 1][r]) % 1000000007;
                }
            }
        }
        return f[0][0][0];
    }

}
