package io.huhu.gokking.algorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BreadthFirstSearchTest {

    @Test
    void search() {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("you", List.of("alice", "bob", "claire"));
        graph.put("bob", List.of("anuj", "peggy"));
        graph.put("alice", List.of("peggy"));
        graph.put("claire", List.of("thom", "jonny"));
        graph.put("anuj", List.of());
        graph.put("peggy", List.of());
        graph.put("thom", List.of());
        graph.put("jonny", List.of());
        assertTrue(BreadthFirstSearch.search(graph));
    }

}
