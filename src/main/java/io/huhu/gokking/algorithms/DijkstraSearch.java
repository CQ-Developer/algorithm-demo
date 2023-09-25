package io.huhu.gokking.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

import static java.lang.Integer.MAX_VALUE;

public final class DijkstraSearch {

    private DijkstraSearch() {}

    /**
     * <img src="./doc-files/DijkstraSearch.png">
     */
    public static int search() {
        // 初始化节点的邻居关系
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("start", Map.of("a", 6, "b", 2));
        graph.put("a", Map.of("end", 1));
        graph.put("b", Map.of("a", 3, "end", 5));
        graph.put("end", new HashMap<>());
        // 初始化节点的消耗
        Map<String, Integer> costs = new HashMap<>();
        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("end", MAX_VALUE);
        // 初始化父节点
        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("end", null);
        // 初始化已处理过的节点
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
        printRoad(parents);
        return costs.get("end");
    }

    private static void printRoad(Map<String, String> parents) {
        StringJoiner joiner = new StringJoiner(" <- ");
        joiner.add("end");
        String node = parents.get("end");
        while (node != null) {
            joiner.add(node);
            node = parents.get(node);
        }
        System.out.println(joiner);
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
