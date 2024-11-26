package io.huhu.leetcode.n1594;

class DynamicProgramming implements Code {

    private static final int M = 1_000_000_007;

    @Override
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] maxProducts = new long[m][n], minProducts = new long[m][n];
        maxProducts[0][0] = minProducts[0][0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            maxProducts[0][j] = minProducts[0][j] = maxProducts[0][j - 1] * grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            maxProducts[i][0] = minProducts[i][0] = maxProducts[i - 1][0] * grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] >= 0) {
                    maxProducts[i][j] = Math.max(maxProducts[i - 1][j], maxProducts[i][j - 1]) * grid[i][j];
                    minProducts[i][j] = Math.min(minProducts[i - 1][j], minProducts[i][j - 1]) * grid[i][j];
                } else {
                    maxProducts[i][j] = Math.min(minProducts[i - 1][j], minProducts[i][j - 1]) * grid[i][j];
                    minProducts[i][j] = Math.max(maxProducts[i - 1][j], maxProducts[i][j - 1]) * grid[i][j];
                }
            }
        }
        return (int) (maxProducts[m - 1][n - 1] < 0 ? -1 : maxProducts[m - 1][n - 1] % M);
    }

}
