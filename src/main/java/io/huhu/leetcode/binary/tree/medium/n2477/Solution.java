package io.huhu.leetcode.binary.tree.medium.n2477;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/minimum-fuel-cost-to-report-to-the-capital/description/">
 * Minimum Fuel Cost to Report to the Capital
 * </a>
 */
class Solution {

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        var graph = buildGraph(roads, n);
        long[] cost = new long[n];
        f(graph, seats, 0, -1, new int[n], cost);
        return cost[0];
    }

    private List<List<Integer>> buildGraph(int[][] roads, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int f = road[0], t = road[1];
            graph.get(f).add(t);
            graph.get(t).add(f);
        }
        return graph;
    }

    private void f(List<List<Integer>> graph, int seats, int c, int p, int[] size, long[] cost) {
        size[c] = 1;
        for (int n : graph.get(c)) {
            // aviod back to parent
            if (n != p) {
                f(graph, seats, n, c, size, cost);
                // before c
                size[c] += size[n];
                cost[c] += cost[n];
                // arrive c
                cost[c] += (size[n] + seats - 1) / seats;
            }
        }
    }

}
