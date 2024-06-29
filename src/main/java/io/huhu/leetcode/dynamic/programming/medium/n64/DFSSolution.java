package io.huhu.leetcode.dynamic.programming.medium.n64;

final class DFSSolution extends Solution {

    @Override
    public int minPathSum(int[][] grid) {
        int[][] f = new int[grid.length][grid[0].length];
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                f[i][j] = -1;
            }
        }
        return dfs(grid, 0, 0, f);
    }

    private int dfs(int[][] grid, int i, int j, int[][] f) {
        if (f[i][j] != -1) {
            return f[i][j];
        }
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            return grid[i][j];
        }
        int ans = Integer.MAX_VALUE;
        if (i + 1 < grid.length) {
            ans = Math.min(ans, dfs(grid, i + 1, j, f));
        }
        if (j + 1 < grid[i].length) {
            ans = Math.min(ans, dfs(grid, i, j + 1, f));
        }
        return f[i][j] = ans + grid[i][j];
    }

}
