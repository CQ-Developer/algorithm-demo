package io.huhu.gokking.algorithms;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Integer.MAX_VALUE;

public final class DijkstraSearch {

    private DijkstraSearch() {}

    public static int search(Map<String, Map<String, Integer>> graph, Map<String, Integer> costs, Map<String, String> parents) {
        Set<String> processed = new HashSet<>();
        String node = findLowestCostNode(costs, processed);
        while (node != null) {
            Map<String, Integer> neighbors = graph.get(node);
            for (String n : neighbors.keySet()) {
                if (neighbors.get(n) < 0) {
                    throw new RuntimeException("包含负权边，无法进行计算");
                }
                int newCost = costs.get(node) + neighbors.get(n);
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

    private static String findLowestCostNode(Map<String, Integer> costs, Set<String> processed) {
        String node = null;
        int cost = MAX_VALUE;
        for (String n : costs.keySet()) {
            if (!processed.contains(n) && costs.get(n) < cost) {
                node = n;
                cost = costs.get(n);
            }
        }
        return node;
    }

}
