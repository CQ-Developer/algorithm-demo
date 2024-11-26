package io.huhu.leetcode.n1334;

import io.huhu.AC;

import java.util.Arrays;

@AC
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
        // 可以看出空间压缩后的dp算法基本等同于floyd算法
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        int ans = -1, cnt = n;
        for (int i = 0; i < n; i++) {
            int _cnt = 0;
            for (int j = 0; j < n; j++) {
                if (j != i && g[i][j] <= distanceThreshold) {
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
