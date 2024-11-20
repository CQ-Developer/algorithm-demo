package io.huhu.leetcode.n1334;

import io.huhu.AC;

import java.util.Arrays;

@AC
class Dijkstra implements Code {

    private static final int INF = Integer.MAX_VALUE >> 1;

    @Override
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];
        // setup
        for (int[] _g : graph) {
            Arrays.fill(_g, INF);
        }
        // build graph
        for (int[] edge : edges) {
            int f = edge[0], t = edge[1], d = edge[2];
            graph[f][t] = graph[t][f] = d;
        }
        // setup ans
        int cnt = INF, ans = -1;
        // dijkstra
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            Arrays.fill(distance, INF);
            distance[i] = 0;
            for (int j = 0; j < n; j++) {
                int t = -1;
                for (int k = 0; k < n; k++) {
                    if (!visited[k] && (t == -1 || distance[k] < distance[t])) {
                        t = k;
                    }
                }
                visited[t] = true;
                for (int k = 0; k < n; k++) {
                    distance[k] = Math.min(distance[k], distance[t] + graph[t][k]);
                }
            }
            Arrays.fill(visited, false);
            // find the least reachable city with the biggest number
            int _cnt = 0;
            for (int j = 0; j < n; j++) {
                if (distance[j] <= distanceThreshold) {
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
