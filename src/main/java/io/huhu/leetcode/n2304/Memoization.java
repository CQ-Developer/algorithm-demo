package io.huhu.leetcode.n2304;

import io.huhu.AC;

@AC
class Memoization implements Solution {

    @Override
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[][] mem = new int[m][n];
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, f(grid, moveCost, mem, 0, j));
        }
        return res;
    }

    private int f(int[][] g, int[][] c, int[][] m, int i, int j) {
        if (i == g.length - 1) {
            return g[i][j];
        }
        if (m[i][j] != 0) {
            return m[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < g[0].length; k++) {
            res = Math.min(res, f(g, c, m, i + 1, k) + c[g[i][j]][k]);
        }
        return m[i][j] = res + g[i][j];
    }

}
