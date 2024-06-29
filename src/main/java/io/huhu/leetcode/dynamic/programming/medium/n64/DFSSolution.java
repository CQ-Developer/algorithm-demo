package io.huhu.leetcode.dynamic.programming.medium.n64;

import java.util.Arrays;

final class DFSSolution extends Solution {

    @Override
    public int minPathSum(int[][] grid) {
        int[][] mem = new int[grid.length][grid[0].length];
        for (int[] m : mem) {
            Arrays.fill(m, -1);
        }
        return dfs(grid, 0, 0, mem);
    }

    private int dfs(int[][] grid, int i, int j, int[][] mem) {
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            return grid[i][j];
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        int ans = Integer.MAX_VALUE;
        if (i + 1 < grid.length) {
            ans = Math.min(ans, dfs(grid, i + 1, j, mem));
        }
        if (j + 1 < grid[i].length) {
            ans = Math.min(ans, dfs(grid, i, j + 1, mem));
        }
        return mem[i][j] = ans + grid[i][j];
    }

}
