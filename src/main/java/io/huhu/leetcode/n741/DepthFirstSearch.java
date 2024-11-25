package io.huhu.leetcode.n741;

import io.huhu.TLE;

@TLE
class DepthFirstSearch implements Code {

    @Override
    public int cherryPickup(int[][] grid) {
        int ans = f(grid, grid.length, 0, 0, 0);
        return ans == -1 ? 0 : ans;
    }

    private int f(int[][] g, int n, int a, int b, int c) {
        int d = a + b - c;
        if (a == n || b == n || c == n || d == n || g[a][b] == -1 || g[c][d] == -1) {
            return -1;
        }
        if (a == n - 1 && b == n - 1) {
            return g[a][b];
        }
        int pickup = a == c && b == d ? g[a][b] : g[a][b] + g[c][d];
        int ans = f(g, n, a + 1, b, c + 1);
        ans = Math.max(ans, f(g, n, a + 1, b, c));
        ans = Math.max(ans, f(g, n, a, b + 1, c + 1));
        ans = Math.max(ans, f(g, n, a, b + 1, c));
        if (ans == -1) {
            return ans;
        }
        return ans + pickup;
    }

}
