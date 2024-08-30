package io.huhu.leetcode.binary.tree.hard.n2322;

/**
 * <a href="https://leetcode.cn/problems/minimum-score-after-removals-on-a-tree/description/">
 * Minimum Score After Removals on a Tree
 * </a>
 */
class Solution {

    public int minimumScore(int[] nums, int[][] edges) {
        var graph = new Graph(nums.length, edges.length).init(edges);
        var dfn = new DFN(nums.length).init(graph, nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            int a = Math.max(dfn.dfn[edges[i][0]], dfn.dfn[edges[i][1]]);
            for (int j = i + 1; j < edges.length; j++) {
                int b = Math.max(dfn.dfn[edges[j][0]], dfn.dfn[edges[j][1]]);
                int p = Math.min(a, b), q = Math.max(a, b);
                int x = dfn.xor[q], y, z;
                if (p + dfn.size[p] > q) {
                    y = dfn.xor[p] ^ x;
                    z = dfn.xor[1] ^ dfn.xor[p];
                } else {
                    y = dfn.xor[p];
                    z = dfn.xor[1] ^ y ^ x;
                }
                ans = Math.min(ans, Math.max(x, Math.max(y, z)) - Math.min(x, Math.min(y, z)));
            }
        }
        return ans;
    }

    class Graph {

        final int[] head;
        final int[] next;
        final int[] to;

        Graph(int n, int m) {
            head = new int[n + 1];
            next = new int[m * 2 + 1];
            to = new int[m * 2 + 1];
        }

        Graph init(int[][] edges) {
            int i = 1;
            for (var edge : edges) {
                int f = edge[0], t = edge[1];
                next[i] = head[f];
                to[i] = t;
                head[f] = i++;
                next[i] = head[t];
                to[i] = f;
                head[t] = i++;
            }
            return this;
        }

    }

    class DFN {

        int dfnCnt;
        final int[] dfn;
        final int[] size;
        final int[] xor;

        DFN(int n) {
            dfn = new int[n + 1];
            size = new int[n + 1];
            xor = new int[n + 1];
        }

        DFN init(Graph graph, int[] nums) {
            f(graph, nums, 0);
            return this;
        }

        void f(Graph graph, int[] nums, int f) {
            int i = ++dfnCnt;
            dfn[f] = i;
            size[i] = 1;
            xor[i] = nums[f];
            for (int e = graph.head[f]; e != 0; e = graph.next[e]) {
                int t = graph.to[e];
                if (dfn[t] == 0) {
                    f(graph, nums, t);
                    size[i] += size[dfn[t]];
                    xor[i] ^= xor[dfn[t]];
                }
            }
        }

    }

}
