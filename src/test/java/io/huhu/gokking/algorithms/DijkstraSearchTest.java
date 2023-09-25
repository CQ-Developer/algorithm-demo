package io.huhu.gokking.algorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DijkstraSearchTest {

    /**
     * <img src="./doc-files/DijkstraSearch.png">
     */
    @Test
    void search_1() {
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
        assertEquals(6, DijkstraSearch.search(graph, costs, parents));
    }

    /**
     * <img src="./doc-files/DijkstraSearch-1.png">
     */
    @Test
    void search_2() {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("start", Map.of("a", 5, "b", 2));
        graph.put("a", Map.of("c", 4, "d", 2));
        graph.put("b", Map.of("a", 8, "d", 7));
        graph.put("c", Map.of("d", 6, "end", 3));
        graph.put("d", Map.of("end", 1));
        graph.put("end", Map.of());
        Map<String, Integer> costs = new HashMap<>();
        costs.put("a", 5);
        costs.put("b", 2);
        costs.put("c", MAX_VALUE);
        costs.put("d", MAX_VALUE);
        costs.put("end", MAX_VALUE);
        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        assertEquals(8, DijkstraSearch.search(graph, costs, parents));
    }

    /**
     * <img src="./doc-files/DijkstraSearch-2.png">
     */
    @Test
    void search_3() {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("start", Map.of("a", 10));
        graph.put("a", Map.of("b", 20));
        graph.put("b", Map.of("c", 1, "end", 30));
        graph.put("c", Map.of("a", 1));
        graph.put("end", Map.of());
        Map<String, Integer> costs = new HashMap<>();
        costs.put("a", 10);
        costs.put("b", MAX_VALUE);
        costs.put("c", MAX_VALUE);
        costs.put("end", MAX_VALUE);
        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        assertEquals(60, DijkstraSearch.search(graph, costs, parents));
    }

}
