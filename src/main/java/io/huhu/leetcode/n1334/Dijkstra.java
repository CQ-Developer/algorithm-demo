package io.huhu.leetcode.n1334;

import io.huhu.AC;

@AC
class Dijkstra implements Code {

    private static final int INF = Integer.MAX_VALUE >> 1;

    @Override
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        boolean[][] visited = new boolean[n][n];
        int[][] distances = new int[n][n], graph = new int[n][n];
        // setup
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = graph[i][j] = INF;
            }
        }
        // build graph
        for (int[] edge : edges) {
            int f = edge[0], t = edge[1], d = edge[2];
            graph[f][t] = graph[t][f] = d;
        }
        // dijkstra
        for (int i = 0; i < n; i++) {
            distances[i][i] = 0;
            for (int j = 0; j < n; j++) {
                int t = -1;
                for (int k = 0; k < n; k++) {
                    if (!visited[i][k] && (t == -1 || distances[i][k] < distances[i][t])) {
                        t = k;
                    }
                }
                visited[i][t] = true;
                for (int k = 0; k < n; k++) {
                    distances[i][k] = Math.min(distances[i][k], distances[i][t] + graph[t][k]);
                }
            }
        }
        // find the least reachable city with the biggest number
        int cnt = INF, ans = -1;
        for (int i = n - 1; i >= 0; i--) {
            int _cnt = 0;
            for (int j = 0; j < n; j++) {
                if (distances[i][j] <= distanceThreshold) {
                    _cnt++;
                }
            }
            if (_cnt < cnt) {
                cnt = _cnt;
                ans = i;
            }
        }
        return ans;
    }

}
