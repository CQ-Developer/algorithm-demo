package io.huhu.leetcode.topological.sort.n851;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/loud-and-rich/description/">
 * Loud and Rich
 * </a>
 */
class Solution {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegress = new int[n];
        for (int[] a : richer) {
            graph.get(a[0]).add(a[1]);
            indegress[a[1]]++;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
        }
        int l = 0, r = 0;
        int[] queue = new int[n];
        for (int i = 0; i < n; i++) {
            if (indegress[i] == 0) {
                queue[r++] = i;
            }
        }
        while (l < r) {
            int f = queue[l++];
            for (int t : graph.get(f)) {
                if (quiet[ans[f]] < quiet[ans[t]]) {
                    ans[t] = ans[f];
                }
                if (--indegress[t] == 0) {
                    queue[r++] = t;
                }
            }
        }
        return ans;
    }

}
