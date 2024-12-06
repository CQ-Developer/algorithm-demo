package io.huhu.leetcode.n1976;

import io.huhu.AC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@AC
class Dijkstra implements Solution {

    private static final int M = 1_000_000_007;

    private record Node(int i, long d) implements Comparable<Node> {

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.d, o.d);
        }

    }

    @Override
    public int countPaths(int n, int[][] roads) {
        // 建图
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            g.get(u).add(new int[]{v, w});
            g.get(v).add(new int[]{u, w});
        }
        // 记录最短距离
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0] = 0;
        // 记录路径数
        int[] ways = new int[n];
        ways[0] = 1;
        // Dijkstra
        Queue<Node> q = new PriorityQueue<>();
        q.offer(new Node(0, 0));
        while (!q.isEmpty()) {
            var u = q.poll();
            if (u.d > dis[u.i]) {
                continue;
            }
            for (int[] next : g.get(u.i)) {
                int v = next[0];
                long _dis = u.d + next[1];
                if (_dis == dis[v]) {
                    ways[v] = (ways[u.i] + ways[v]) % M;
                } else if (_dis < dis[v]) {
                    dis[v] = _dis;
                    ways[v] = ways[u.i];
                    q.offer(new Node(v, _dis));
                }
            }
        }
        return ways[n - 1];
    }

}
