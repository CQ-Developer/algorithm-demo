package io.huhu.leetcode.dynamic.programming.hard.n2435;

final class DFS implements Solution {

    @Override
    public int numberOfPaths(int[][] grid, int k) {
        return dfs(grid, 0, 0, 0, k);
    }

    private int dfs(int[][] grid, int i, int j, int s, int k) {
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            return (s + grid[i][j]) % k == 0 ? 1 : 0;
        }
        int ans = 0;
        if (i < grid.length - 1) {
            ans += dfs(grid, i + 1, j, s + grid[i][j], k);
        }
        if (j < grid[i].length - 1) {
            ans += dfs(grid, i, j + 1, s + grid[i][j], k);
        }
        return ans % 1000000007;
    }

}
