package io.huhu.breadth.first.search.n691;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution1 implements Code {

    /**
     * TODO WA
     */
    @Override
    public int minStickers(String[] stickers, String target) {
        // setup graph
        List<List<String>> graph = setupGraph(stickers);
        // setup bfs
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        target = sort(target);
        visited.add(target);
        queue.offer(target);
        // bfs
        int lever = 1;
        while (!queue.isEmpty()) {
            var f = queue.poll();
            for (var s : graph.get(f.charAt(0) - 'a')) {
                var t = reduceCommon(f, s);
                if (t.isEmpty()) {
                    return lever;
                } else if (!visited.contains(t)) {
                    visited.add(t);
                    queue.offer(t);
                }
            }
            lever++;
        }
        return -1;
    }

    private List<List<String>> setupGraph(String[] stickers) {
        List<List<String>> graph = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        for (var sticker : stickers) {
            var s = sort(sticker);
            for (int i = 0; i < sticker.length(); i++) {
                if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                    graph.get(s.charAt(i) - 'a').add(s);
                }
            }
        }
        return graph;
    }

    private String sort(String str) {
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }

    private String reduceCommon(String f, String s) {
        var builder = new StringBuilder();
        for (int i = 0, j = 0; i < f.length();) {
            if (j == s.length()) {
                builder.append(f.charAt(i++));
            } else {
                if (f.charAt(i) < s.charAt(j)) {
                    builder.append(f.charAt(i++));
                } else if (f.charAt(i) > s.charAt(j)) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return builder.toString();
    }

}
