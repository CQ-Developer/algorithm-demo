package io.huhu.leetcode.binary.tree.hard.n2246;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-path-with-different-adjacent-characters/description/">
 * Longest Path With Different Adjacent Characters
 * </a>
 */
class Solution {

    public int longestPath(int[] parent, String s) {
        var graph = new Graph(parent.length).build(parent);
        return f(graph, s.toCharArray(), 0).maxPath;
    }

    private Info f(Graph graph, char[] s, int f) {
        int max1 = 0, max2 = 0, maxPath = 1;
        for (int e = graph.head[f]; e != -1; e = graph.next[e]) {
            int t = graph.to[e];
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

    private class Graph {

        final int[] head;
        final int[] next;
        final int[] to;

        Graph(int n) {
            head = new int[n];
            next = new int[n];
            to = new int[n];
        }

        Graph build(int[] parent) {
            int e = 0;
            Arrays.fill(head, -1);
            for (int t = 1; t < parent.length; t++) {
                int f = parent[t];
                next[e] = head[f];
                to[e] = t;
                head[f] = e++;
            }
            return this;
        }

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
