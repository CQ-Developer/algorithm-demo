package io.huhu.leetcode.n741;

import io.huhu.AC;

import java.util.Arrays;

@AC
class DynamicProgramming implements Code {

    @Override
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] f = new int[n + 1][n + 1];
        for (int[] _f : f) {
            Arrays.fill(_f, -2);
        }
        f[1][1] = grid[0][0];
        for (int s = 1; s < 2 * n - 1; s++) {
            for (int i1 = Math.min(s, n - 1); i1 >= Math.max(s - n + 1, 0); i1--) {
                for (int i2 = Math.min(s, n - 1); i2 >= i1; i2--) {
                    if (grid[i1][s - i1] == -1 || grid[i2][s - i2] == -1) {
                        f[i1 + 1][i2 + 1] = -2;
                    } else {
                        int ans = Math.max(f[i1 + 1][i2 + 1], Math.max(f[i1][i2 + 1], Math.max(f[i1 + 1][i2], f[i1][i2])));
                        if (ans != -2) {
                            ans += grid[i1][s - i1] + (i1 == i2 ? 0 : grid[i2][s - i2]);
                        }
                        f[i1 + 1][i2 + 1] = ans;
                    }
                }
            }
        }
        return Math.max(f[n][n], 0);
    }

}
