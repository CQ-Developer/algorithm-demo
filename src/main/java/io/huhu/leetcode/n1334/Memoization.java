package io.huhu.leetcode.n1334;

import java.util.Arrays;

class Memoization implements Code {

    private static final int INF = Integer.MAX_VALUE >> 1;

    @Override
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] g = new int[n][n];
        for (int[] _g : g) {
            Arrays.fill(_g, INF);
        }
        for (int[] edge : edges) {
            int f = edge[0], t = edge[1];
            g[f][t] = g[t][f] = edge[2];
        }
        int ans = -1, cnt = n;
        int[][][] mem = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            int _cnt = 0;
            for (int j = 0; j < n; j++) {
                if (j != i && f(n - 1, i, j, g, mem) <= distanceThreshold) {
                    _cnt++;
                }
            }
            if (_cnt <= cnt) {
                cnt = _cnt;
                ans = i;
            }
        }
        return ans;
    }

    private int f(int k, int i, int j, int[][] g, int[][][] mem) {
        if (k == -1) {
            return g[i][j];
        }
        if (mem[k][i][j] != 0) {
            return mem[k][i][j];
        }
        return mem[k][i][j] = Math.min(f(k - 1, i, j, g, mem), f(k - 1, i, k, g, mem) + f(k - 1, k, j, g, mem));
    }

}
