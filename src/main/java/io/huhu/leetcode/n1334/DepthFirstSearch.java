package io.huhu.leetcode.n1334;

import io.huhu.TLE;

import java.util.Arrays;

@TLE
class DepthFirstSearch implements Code {

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
        for (int i = 0; i < n; i++) {
            int _cnt = 0;
            for (int j = 0; j < n; j++) {
                if (j != i && f(n - 1, i, j, g) <= distanceThreshold) {
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

    /**
     * f(k,i,j)表示从i到j的最短路径, 并且该最短路径中间的节点编号均小于等于k
     */
    private int f(int k, int i, int j, int[][] g) {
        if (k == -1) {
            return g[i][j];
        }
        // 1. 不经过k节点
        // 2. 经过k节点
        return Math.min(f(k - 1, i, j, g), f(k - 1, i, k, g) + f(k - 1, k, j, g));
    }

}
