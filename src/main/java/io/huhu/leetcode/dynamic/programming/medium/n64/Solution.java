package io.huhu.leetcode.dynamic.programming.medium.n64;

/**
 * <a href="https://leetcode.cn/problems/minimum-path-sum/description/">最小路径和</a>
 */
class Solution {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 初始化第一列
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        // 初始化第一行
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        // 动态规划
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

}
