package io.huhu.gokking.algorithms;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class BreadthFirstSearch {

    private BreadthFirstSearch() {}

    public static boolean search(Map<String, List<String>> graph) {
        Deque<String> searchQueue = new LinkedList<>(graph.get("you"));
        Set<String> searched = new HashSet<>();
        // 深度有限搜索
        while (!searchQueue.isEmpty()) {
            String name = searchQueue.pollFirst();
            if (searched.add(name)) {
                if (isSeller(name)) {
                    System.out.printf("%s is a seller%n", name);
                    return true;
                }
                else {
                    searchQueue.addAll(graph.get(name));
                }
            }
        }
        return false;
    }

    private static boolean isSeller(String name) {
        return 'm' == name.charAt(name.length() - 1);
    }

}
