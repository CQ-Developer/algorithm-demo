package io.huhu.leetcode.n1976;

import io.huhu.AC;

import java.util.Arrays;

@AC
class DynamicProgramming implements Solution {

    private static final int M = 1_000_000_007;

    @Override
    public int countPaths(int n, int[][] roads) {
        // 建图: 链接矩阵
        int[][] g = new int[n][n];
        for (int[] _g : g) {
            Arrays.fill(_g, Integer.MAX_VALUE);
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1];
            g[u][v] = g[v][u] = road[2];
        }
        // vis[i]: 是否已经从i节点出发过
        boolean[] vis = new boolean[n];
        // dis[i]: 从0出发到达i节点的最短路径距离
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE >> 1);
        dis[0] = 0;
        // f[i]: 从0出发到达i节点的最短路径数
        int[] f = new int[n];
        f[0] = 1;
        // dp
        for (int i = 0; i < n - 1; i++) {
            // 找到没有访问过且与0节点最近的节点作为出发节点
            int u = -1;
            for (int _u = 0; _u < n; _u++) {
                if (!vis[_u] && (u == -1 || dis[_u] < dis[u])) {
                    u = _u;
                }
            }
            // 已从u节点出发过
            vis[u] = true;
            // 遍历从u节点出发的所有可达节点
            for (int v = 0; v < n; v++) {
                // u节点到v节点可达
                if (g[u][v] != Integer.MAX_VALUE) {
                    long _dis = g[u][v] + dis[u];
                    // 找到一条到达v节点更短的路径
                    if (_dis < dis[v]) {
                        f[v] = f[u];
                        dis[v] = _dis;
                    }
                    // 找到了与之前到达v节点距离相同的路径
                    else if (_dis == dis[v]) {
                        f[v] = (f[u] + f[v]) % M;
                    }
                }
            }
        }
        return f[n - 1];
    }

}
