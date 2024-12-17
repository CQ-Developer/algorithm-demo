package io.huhu.leetcode.n2304;

import io.huhu.AC;

@AC
class DynamicProgramming implements Solution {

    @Override
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        f[m - 1] = grid[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    f[i][j] = Math.min(f[i][j], f[i + 1][k] + moveCost[grid[i][j]][k]);
                }
                f[i][j] += grid[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : f[0]) {
            res = Math.min(res, i);
        }
        return res;
    }

}
