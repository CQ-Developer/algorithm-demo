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
        for (int i = 1; i <= n; i++) {
            queue.offer(new int[]{i, distances[i]});
        }
        int[] f = new int[n + 1];
        f[n] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], d = cur[1];
            for (int[] next : graph.get(i)) {
                int _i = next[0], _d = distances[_i];
                if (_d < d) {
                    f[i] = (f[i] + f[_i]) % M;
                }
            }
        }
        return f[1];
    }

}
