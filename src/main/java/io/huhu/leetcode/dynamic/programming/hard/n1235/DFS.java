package io.huhu.leetcode.dynamic.programming.hard.n1235;

import java.util.Arrays;

class DFS implements Solution {

    @Override
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] table = sortEndTime(startTime, endTime, profit);
        int n = table.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(table, dp, n - 1);
    }

    private int[][] sortEndTime(int[] start, int[] end, int[] profit) {
        int n = start.length;
        int[][] table = new int[n][3];
        for (int i = 0; i < n; i++) {
            table[i][0] = start[i];
            table[i][1] = end[i];
            table[i][2] = profit[i];
        }
        Arrays.sort(table, (a, b) -> a[1] - b[1]);
        return table;
    }

    private int dfs(int[][] table, int[] dp, int i) {
        if (i == -1) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans = table[i][2];
        if (table[0][1] <= table[i][0]) {
            ans += dfs(table, dp, find(i, table));
        }
        return dp[i] = Math.max(dfs(table, dp, i - 1), ans);
    }

    private int find(int i, int[][] table) {
        int l = 0, r = i - 1, ans = 0;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (table[m][1] <= table[i][0]) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

}
