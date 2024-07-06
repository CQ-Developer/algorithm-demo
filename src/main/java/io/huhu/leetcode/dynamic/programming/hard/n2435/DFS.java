package io.huhu.leetcode.dynamic.programming.hard.n2435;

final class DFS implements Solution {

    @Override
    public int numberOfPaths(int[][] grid, int k) {
        int[][][] f = new int[grid.length][grid[0].length][k];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                for (int x = 0; x < k; x++) {
                    f[i][j][x] = -1;
                }
            }
        }
        return dfs(grid, 0, 0, k, 0, f);
    }

    private int dfs(int[][] grid, int i, int j, int k, int r, int[][][] f) {
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            return grid[i][j] % k == r ? 1 : 0;
        }
        if (f[i][j][r] != -1) {
            return f[i][j][r];
        }
        int n = (k + r - grid[i][j] % k) % k;
        int ans = 0;
        if (i + 1 < grid.length) {
            ans += dfs(grid, i + 1, j, k, n, f);
        }
        if (j + 1 < grid[i].length) {
            ans += dfs(grid, i, j + 1, k, n, f);
        }
        return f[i][j][r] = ans % 1000000007;
    }

}
