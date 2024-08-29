package io.huhu.leetcode.binary.tree.hard.n2246;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/longest-path-with-different-adjacent-characters/description/">
 * Longest Path With Different Adjacent Characters
 * </a>
 */
class Solution {

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        var graph = buildGraph(n, parent);
        return f(graph, s.toCharArray(), 0).maxPath;
    }

    private List<List<Integer>> buildGraph(int n, int[] parent) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            graph.get(parent[i]).add(i);
        }
        return graph;
    }

    private Info f(List<List<Integer>> graph, char[] s, int f) {
        if (graph.get(f).isEmpty()) {
            return new Info(1, 1);
        }
        int max1 = 0, max2 = 0, maxPath = 1;
        for (int t : graph.get(f)) {
            var info = f(graph, s, t);
            maxPath = Math.max(maxPath, info.maxPath);
            if (s[f] != s[t]) {
                if (info.maxPathFromHead > max1) {
                    max2 = max1;
                    max1 = info.maxPathFromHead;
                } else if (info.maxPathFromHead > max2) {
                    max2 = info.maxPathFromHead;
                }
            }
        }
        maxPath = Math.max(maxPath, max1 + max2 + 1);
        return new Info(maxPath, max1 + 1);
    }

    private class Info {

        final int maxPath;
        final int maxPathFromHead;

        Info(int maxPath, int maxPathFromHead) {
            this.maxPath = maxPath;
            this.maxPathFromHead = maxPathFromHead;
        }

    }

}
