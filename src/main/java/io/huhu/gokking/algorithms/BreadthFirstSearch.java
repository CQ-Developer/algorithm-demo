package io.huhu.gokking.algorithms;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class BreadthFirstSearch {

    private BreadthFirstSearch() {}

    public static boolean search() {
        // 初始化图
        var map = HashMap.<String, List<String>>newHashMap(8);
        map.put("you", List.of("alice", "bob", "claire"));
        map.put("bob", List.of("anuj", "peggy"));
        map.put("alice", List.of("peggy"));
        map.put("claire", List.of("thom", "jonny"));
        map.put("anuj", List.of());
        map.put("peggy", List.of());
        map.put("thom", List.of());
        map.put("jonny", List.of());
        // 初始化队列
        Deque<String> searchQueue = new LinkedList<>(map.get("you"));
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
                    searchQueue.addAll(map.get(name));
                }
            }
        }
        return false;
    }

    private static boolean isSeller(String name) {
        return 'm' == name.charAt(name.length() - 1);
    }

}
