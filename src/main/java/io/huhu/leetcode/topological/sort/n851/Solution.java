package io.huhu.leetcode.topological.sort.n851;

/**
 * <a href="https://leetcode.cn/problems/loud-and-rich/description/">
 * Loud and Rich
 * </a>
 */
class Solution {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length, m = richer.length;
        int edge = 1;
        int[] head = new int[n];
        int[] next = new int[m + 1];
        int[] to = new int[m + 1];
        int[] indegress = new int[n];
        for (int[] a : richer) {
            int f = a[0], t = a[1];
            next[edge] = head[f];
            to[edge] = t;
            head[f] = edge++;
            indegress[t]++;
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
            for (int e = head[f]; e > 0; e = next[e]) {
                int t = to[e];
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
