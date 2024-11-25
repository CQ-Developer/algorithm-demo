package io.huhu.leetcode.n741;

import io.huhu.AC;

import java.util.Arrays;

@AC
class Memoization implements Code {

    @Override
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] mem = new int[n][n][n];
        for (int[][] a : mem) {
            for (int[] b : a) {
                Arrays.fill(b, -2);
            }
        }
        int ans = f(grid, n, mem, 0, 0, 0);
        return ans == -1 ? 0 : ans;
    }

    private int f(int[][] g, int n, int[][][] mem, int a, int b, int c) {
        int d = a + b - c;
        if (a == n || b == n || c == n || d == n || g[a][b] == -1 || g[c][d] == -1) {
            return -1;
        }
        if (a == n - 1 && b == n - 1) {
            return g[a][b];
        }
        if (mem[a][b][c] != -2) {
            return mem[a][b][c];
        }
        int ans = f(g, n, mem, a + 1, b, c + 1);
        ans = Math.max(ans, f(g, n, mem, a + 1, b, c));
        ans = Math.max(ans, f(g, n, mem, a, b + 1, c + 1));
        ans = Math.max(ans, f(g, n, mem, a, b + 1, c));
        if (ans != -1) {
            ans += a == c && b == d ? g[a][b] : g[a][b] + g[c][d];
        }
        return mem[a][b][c] = ans;
    }

}
