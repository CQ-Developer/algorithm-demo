package io.huhu.leetcode.topological.sort.n936;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/stamping-the-sequence/description/">
 * Stamping The Sequence
 * </a>
 */
class Solution {

    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray(), t = target.toCharArray();
        int m = s.length, n = t.length;
        // init indegress
        int[] indegress = new int[n - m + 1];
        Arrays.fill(indegress, m);
        // init graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // build graph and indegress
        int l = 0, r = 0;
        int[] queue = new int[n - m + 1];
        for (int i = 0; i <= n - m; i++) {
            for (int j = 0; j < m; j++) {
                if (t[i + j] == s[j]) {
                    if (--indegress[i] == 0) {
                        queue[r++] = i;
                    }
                } else {
                    graph.get(i + j).add(i);
                }
            }
        }
        // topological sort
        int size = 0;
        int[] path = new int[n - m + 1];
        boolean[] visited = new boolean[n];
        while (l < r) {
            int cur = queue[l++];
            path[size++] = cur;
            for (int i = 0; i < m; i++) {
                if (!visited[cur + i]) {
                    visited[cur + i] = true;
                    for (int next : graph.get(cur + i)) {
                        if (--indegress[next] == 0) {
                            queue[r++] = next;
                        }
                    }
                }
            }
        }
        // check if there is cycle
        if (size != n - m + 1) {
            return new int[0];
        }
        // reverse array
        for (int i = 0, j = size - 1; i < j; i++, j--) {
            int num = path[i];
            path[i] = path[j];
            path[j] = num;
        }
        return path;
    }

}
