package io.huhu.gokking.algorithms;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Integer.MAX_VALUE;

public final class DijkstraSearch {

    private DijkstraSearch() {}

    public static int search(Map<String, Map<String, Integer>> graph, Map<String, Integer> costs, Map<String, String> parents) {
        Set<String> processed = new HashSet<>();
        // 开始算法流程
        String node = findLowestCostNode(costs, processed);
        while (node != null) {
            int cost = costs.get(node);
            Map<String, Integer> neighbors = graph.get(node);
            for (String n : neighbors.keySet()) {
                int newCost = cost + neighbors.get(n);
                if (costs.get(n) > newCost) {
                    costs.put(n, newCost);
                    parents.put(n, node);
                }
            }
            processed.add(node);
            node = findLowestCostNode(costs, processed);
        }
        return costs.get("end");
    }

    static String findLowestCostNode(Map<String, Integer> costs, Set<String> processed) {
        String node = null;
        int min = MAX_VALUE;
        for (String key : costs.keySet()) {
            if (!processed.contains(key) && costs.get(key) < min) {
                node = key;
                min = costs.get(key);
            }
        }
        return node;
    }

}
