package io.huhu.leetcode.n741;

import io.huhu.TLE;

@TLE
class DepthFirstSearch implements Code {

    @Override
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        return Math.max(0, f(grid, 2 * n - 2, n - 1, n - 1));
    }

    /**
     * n represent the total steps can move,
     * j1 = n - i1, j2 = n - i2
     */
    private int f(int[][] g, int n, int i1, int i2) {
        if (i1 < 0 || n < i1 || i2 < 0 || n < i2 || g[i1][n - i1] == -1 || g[i2][n - i2] == -1) {
            return -2;
        }
        if (n == 0) {
            return g[0][0];
        }
        // (n - 1, i1,         i2) means (i1,     j1 - 1, i2,     j2 - 1)
        // (n - 1, i1 - 1,     i2) means (i1 - 1, j1,     i2,     j2 - 1)
        // (n - 1, i1,     i2 - 1) means (i1,     j1 - 1, i2 - 1, j2)
        // (n - 1, i1 - 1, i2 - 1) means (i1 - 1, j1,     i2 - 1, j2)
        int ans = Math.max(f(g, n - 1, i1, i2), Math.max(f(g, n - 1, i1 - 1, i2), Math.max(f(g, n - 1, i1, i2 - 1), f(g, n - 1, i1 - 1, i2 - 1))));
        if (ans != -2) {
            ans += g[i1][n - i1] + (i1 == i2 ? 0 : g[i2][n - i2]);
        }
        return ans;
    }

}
