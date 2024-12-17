package io.huhu.leetcode.n2304;

import io.huhu.TLE;

@TLE
class DepthFirstSearch implements Solution {

    @Override
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < grid[0].length; j++) {
            res = Math.min(res, f(grid, moveCost, 0, j));
        }
        return res;
    }

    private int f(int[][] g, int[][] c, int i, int j) {
        if (i == g.length - 1) {
            return g[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < g[0].length; k++) {
            res = Math.min(res, f(g, c, i + 1, k) + c[g[i][j]][k]);
        }
        return res + g[i][j];
    }

}
