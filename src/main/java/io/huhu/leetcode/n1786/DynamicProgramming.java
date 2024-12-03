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
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int f = edge[0], t = edge[1], d = edge[2];
            graph.get(f).add(new int[]{t, d});
            graph.get(t).add(new int[]{f, d});
        }
        int[] ds = new int[n + 1];
        Arrays.fill(ds, Integer.MAX_VALUE);
        ds[n] = 0;
        int[] dp = new int[n + 1];
        dp[n] = 1;
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        heap.offer(new int[]{n, 0});
        while (!heap.isEmpty()) {
            int[] top = heap.poll();
            int f = top[0], d = top[1];
            if (f == 1) {
                break;
            }
            if (d <= ds[f]) {
                for (int[] next : graph.get(f)) {
                    int t = next[0], _d = next[1];
                    if (ds[t] > ds[f] + _d) {
                        ds[t] = ds[f] + _d;
                        heap.offer(new int[]{t, ds[t]});
                    }
                    if (ds[t] > ds[f]) {
                        dp[t] = (dp[t] + dp[f]) % M;
                    }
                }
            }
        }
        return dp[1];
    }

}
