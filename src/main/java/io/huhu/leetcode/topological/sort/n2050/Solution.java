package io.huhu.leetcode.topological.sort.n2050;

/**
 * <a href="https://leetcode.cn/problems/parallel-courses-iii/description/">
 * Parallel Courses III
 * </a>
 */
class Solution {

    public int minimumTime(int n, int[][] relations, int[] time) {
        int m = relations.length;
        int edge = 1;
        int[] head = new int[n + 1];
        int[] next = new int[m + 1];
        int[] to = new int[m + 1];
        int[] indegress = new int[n + 1];
        for (int[] relation : relations) {
            int f = relation[0], t = relation[1];
            next[edge] = head[f];
            to[edge] = t;
            head[f] = edge++;
            indegress[t]++;
        }
        int l = 0, r = 0;
        int[] queue = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (indegress[i] == 0) {
                queue[r++] = i;
            }
        }
        int ans = 0;
        int[] cost = new int[n + 1];
        while (l < r) {
            int f = queue[l++];
            cost[f] += time[f - 1];
            ans = Math.max(ans, cost[f]);
            for (int e = head[f]; e > 0; e = next[e]) {
                int t = to[e];
                cost[t] = Math.max(cost[t], cost[f]);
                if (--indegress[t] == 0) {
                    queue[r++] = t;
                }
            }
        }
        return ans;
    }

}
