package io.huhu.leetcode.n741;

import io.huhu.AC;

import java.util.Arrays;

@AC
class DynamicProgramming implements Code {

    @Override
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] f = new int[n + 1][n + 1], _f = new int[n + 1][n + 1];
        for (int[] a : f) {
            Arrays.fill(a, -1);
        }
        for (int a = n - 1; a >= 0; a--) {
            for (int b = n; b >= 0; b--) {
                for (int c = n; c >= 0; c--) {
                    int d = a + b - c;
                    if (d >= 0 && d <= n) {
                        int ans;
                        if (b == n || c == n || d == n || grid[a][b] == -1 || grid[c][d] == -1) {
                            ans = -1;
                        } else if (a == n - 1 && b == n - 1) {
                            ans = grid[a][b];
                        } else {
                            ans = f[b][c + 1];
                            ans = Math.max(ans, f[b][c]);
                            ans = Math.max(ans, _f[b + 1][c + 1]);
                            ans = Math.max(ans, _f[b + 1][c]);
                            if (ans != -1) {
                                ans += a == c && b == d ? grid[a][b] : grid[a][b] + grid[c][d];
                            }
                        }
                        _f[b][c] = ans;
                    }
                }
            }
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    f[i][j] = _f[i][j];
                }
            }
        }
        return f[0][0] == -1 ? 0 : f[0][0];
    }

}
