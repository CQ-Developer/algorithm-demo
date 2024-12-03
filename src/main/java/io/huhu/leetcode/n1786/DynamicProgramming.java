package io.huhu.leetcode.n1786;

import io.huhu.AC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@AC
class DynamicProgramming implements Code {

    private static final int M = 1_000_000_007;

    @Override
    public int countRestrictedPaths(int n, int[][] edges) {
        // build graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int f = edge[0], t = edge[1], d = edge[2];
            graph.get(f).add(new int[]{t, d});
            graph.get(t).add(new int[]{f, d});
        }
        // Dijkstra
        boolean[] visited = new boolean[n + 1];
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[n] = 0;
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{n, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int t = cur[0];
            if (!visited[t]) {
                visited[t] = true;
                for (int[] pre : graph.get(t)) {
                    int f = pre[0];
                    distances[f] = Math.min(distances[f], distances[t] + pre[1]);
                    queue.offer(new int[]{f, distances[f]});
                }
            }
        }
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{i + 1, distances[i + 1]};
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        // dp
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = 0; i < n; i++) {
            int f = arr[i][0], d = arr[i][1];
            for (int[] next : graph.get(f)) {
                int t = next[0];
                if (d > distances[t]) {
                    dp[f] = (dp[f] + dp[t]) % M;
                }
            }
            if (f == 1) {
                break;
            }
        }
        return dp[1];
    }

}
