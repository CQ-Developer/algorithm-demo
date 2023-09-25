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
    void search() {
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

}
