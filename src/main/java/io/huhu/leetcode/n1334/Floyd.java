package io.huhu.leetcode.n1334;

import io.huhu.AC;

@AC
class Floyd implements Code {

    private static final int INF = Integer.MAX_VALUE >> 1;

    @Override
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] g = new int[n][n];
        for (int[] _g : g) {
            for (int i = 0; i < n; i++) {
                _g[i] = INF;
            }
        }
        // 无向图
        for (int[] edge : edges) {
            int f = edge[0], t = edge[1], d = edge[2];
            g[f][t] = g[t][f] = d;
        }
        // !城市间的最短距离
        for (int k = 0; k < n; k++) {
            g[k][k] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        int ans = n, cnt = INF;
        for (int i = n - 1; i >= 0; i--) {
            int _cnt = 0;
            for (int d : g[i]) {
                // 在阈值内能到达的城市数量
                if (d <= distanceThreshold) {
                    _cnt++;
                }
            }
            // 能到达的城市最少且城市编号最大
            if (_cnt < cnt) {
                cnt = _cnt;
                ans = i;
            }
        }
        return ans;
    }

}
