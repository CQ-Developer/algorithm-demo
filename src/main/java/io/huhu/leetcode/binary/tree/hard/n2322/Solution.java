package io.huhu.leetcode.binary.tree.hard.n2322;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/minimum-score-after-removals-on-a-tree/description/">
 * Minimum Score After Removals on a Tree
 * </a>
 */
class Solution {

    private static final int MAXN = 1001;

    private static final int[] dfn = new int[MAXN];
    private static final int[] size = new int[MAXN];
    private static final int[] xor = new int[MAXN];

    private int dfnCnt;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        Arrays.fill(dfn, 0, n, 0);
        var graph = buildGraph(n, edges);
        f(nums, graph, 0);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            int a = Math.max(dfn[edges[i][0]], dfn[edges[i][1]]);
            for (int j = i + 1; j < edges.length; j++) {
                int b = Math.max(dfn[edges[j][0]], dfn[edges[j][1]]);
                int p, q;
                if (a < b) {
                    p = a;
                    q = b;
                } else {
                    p = b;
                    q = a;
                }
                int y, z;
                int x = xor[q];
                // q is subtree of p
                if (q < p + size[p]) {
                    y = xor[q] ^ xor[p];
                    z = xor[1] ^ xor[p];
                } else {
                    y = xor[p];
                    z = xor[1] ^ x ^ y;
                }
                ans = Math.min(ans, Math.max(x, Math.max(y, z)) - Math.min(x, Math.min(y, z)));
            }
        }
        return ans;
    }

    private List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    private void f(int[] nums, List<List<Integer>> graph, int f) {
        int i = ++dfnCnt;
        dfn[f] = i;
        size[i] = 1;
        xor[i] = nums[f];
        for (int t : graph.get(f)) {
            if (dfn[t] == 0) {
                f(nums, graph, t);
                size[i] += size[dfn[t]];
                xor[i] ^= xor[dfn[t]];
            }
        }
    }

}
