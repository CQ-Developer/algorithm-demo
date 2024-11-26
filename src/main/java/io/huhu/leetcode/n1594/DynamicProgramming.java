package io.huhu.leetcode.n1594;

class DynamicProgramming implements Code {

    private static final int M = 1_000_000_007;

    @Override
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[] maxProducts = new long[n], minProducts = new long[n];
        maxProducts[0] = minProducts[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            maxProducts[j] = minProducts[j] = maxProducts[j - 1] * grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            maxProducts[0] = minProducts[0] = maxProducts[0] * grid[i][0];
            for (int j = 1; j < n; j++) {
                if (grid[i][j] >= 0) {
                    maxProducts[j] = Math.max(maxProducts[j], maxProducts[j - 1]) * grid[i][j];
                    minProducts[j] = Math.min(minProducts[j], minProducts[j - 1]) * grid[i][j];
                } else {
                    long t = maxProducts[j];
                    maxProducts[j] = Math.min(minProducts[j], minProducts[j - 1]) * grid[i][j];
                    minProducts[j] = Math.max(t, maxProducts[j - 1]) * grid[i][j];
                }
            }
        }
        return (int) (maxProducts[n - 1] < 0 ? -1 : maxProducts[n - 1] % M);
    }

}
