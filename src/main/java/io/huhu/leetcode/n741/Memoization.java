package io.huhu.leetcode.n741;

import io.huhu.AC;

import java.util.Arrays;

@AC
class Memoization implements Code {

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] mem = new int[2 * n - 1][n][n];
        for (int[][] a : mem) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return Math.max(0, f(grid, mem, 2 * n - 2, n - 1, n - 1));
    }

    private int f(int[][] g, int[][][] mem, int n, int i1, int i2) {
        if (i1 < 0 || n < i1 || i2 < 0 || n < i2 || g[i1][n - i1] == -1 || g[i2][n - i2] == -1) {
            return -2;
        }
        if (n == 0) {
            return g[0][0];
        }
        if (mem[n][i1][i2] != -1) {
            return mem[n][i1][i2];
        }
        int ans = mem[n][i1][i2] = Math.max(f(g, mem, n - 1, i1, i2), Math.max(f(g, mem, n - 1, i1 - 1, i2), Math.max(f(g, mem, n - 1, i1, i2 - 1), f(g, mem, n - 1, i1 - 1, i2 - 1))));
        if (ans != -2) {
            ans += g[i1][n - i1] + (i1 == i2 ? 0 : g[i2][n - i2]);
        }
        return mem[n][i1][i2] = ans;
    }

}
