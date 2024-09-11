package io.huhu.leetcode.dynamic.programming.hard.n1235;

import java.util.Arrays;

class DP implements Solution {

    @Override
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] schedule = sortByEndTime(startTime, endTime, profit, n);
        int[] dp = new int[n];
        dp[0] = schedule[0][2];
        for (int i = 1; i < n; i++) {
            dp[i] = schedule[i][2];
            if (schedule[0][1] <= schedule[i][0]) {
                dp[i] += dp[find(schedule, i)];
            }
            dp[i] = Math.max(dp[i - 1], dp[i]);
        }
        return dp[n - 1];
    }

    private int find(int[][] schedule, int i) {
        int l = 0, r = i - 1, ans = 0;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (schedule[m][1] <= schedule[i][0]) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    private int[][] sortByEndTime(int[] start, int[] end, int[] profit, int n) {
        int[][] ans = new int[n][3];
        for (int i = 0; i < n; i++) {
            ans[i][0] = start[i];
            ans[i][1] = end[i];
            ans[i][2] = profit[i];
        }
        Arrays.sort(ans, (a, b) -> a[1] - b[1]);
        return ans;
    }

}
