package io.huhu.leetcode.dynamic.programming.medium.n983;

class DP implements Solution {

    @Override
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length, last = days[n - 1];
        int[] dp = new int[last + 1];
        for (int i = 1, j = 0; i < dp.length; i++) {
            if (i == days[j]) {
                int a = costs[0] + (i >= 1 ? dp[i - 1] : 0);
                int b = costs[1] + (i >= 7 ? dp[i - 7] : 0);
                int c = costs[2] + (i >= 30 ? dp[i - 30] : 0);
                dp[i] = Math.min(a, Math.min(b, c));
                j++;
            }
            else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[last];
    }

}
