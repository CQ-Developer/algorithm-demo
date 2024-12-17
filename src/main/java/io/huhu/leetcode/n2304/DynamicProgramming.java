package io.huhu.leetcode.n2304;

import io.huhu.AC;

@AC
class DynamicProgramming implements Solution {

    @Override
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int[] cost = moveCost[grid[i][j]];
                int res = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    res = Math.min(res, grid[i + 1][k] + cost[k]);
                }
                grid[i][j] += res;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : grid[0]) {
            res = Math.min(res, i);
        }
        return res;
    }

}
