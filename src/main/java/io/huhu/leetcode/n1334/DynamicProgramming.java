package io.huhu.leetcode.n1334;

import java.util.Arrays;

class DynamicProgramming implements Code {

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
        int[][][] dp = new int[n + 1][n][n];
        dp[0] = g;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[k + 1][i][j] = Math.min(dp[k][i][j], dp[k][i][k] + dp[k][k][j]);
                }
            }
        }
        int ans = -1, cnt = n;
        for (int i = 0; i < n; i++) {
            int _cnt = 0;
            for (int j = 0; j < n; j++) {
                if (j != i && dp[n][i][j] <= distanceThreshold) {
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

}
