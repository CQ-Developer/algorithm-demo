package io.huhu.leetcode.n787;

import java.util.Arrays;

class DP implements Code {

    private static final int INF = 49500000;

    @Override
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[k + 2][n];
        for (int[] a : dp) {
            Arrays.fill(a, INF);
        }
        dp[0][src] = 0;
        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight : flights) {
                int f = flight[0], t = flight[1], p = flight[2];
                dp[i][t] = Math.min(dp[i][t], dp[i - 1][f] + p);
            }
        }
        int ans = INF;
        for (int i = 0; i <= k + 1; i++) {
            ans = Math.min(ans, dp[i][dst]);
        }
        return ans == INF ? -1 : ans;
    }

}
