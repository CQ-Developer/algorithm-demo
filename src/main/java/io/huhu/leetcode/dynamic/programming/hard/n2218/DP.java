package io.huhu.leetcode.dynamic.programming.hard.n2218;

import java.util.List;

class DP implements Solution {

    @Override
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            List<Integer> list = piles.get(i - 1);
            int m = Integer.min(list.size(), k);
            int[] sum = new int[m + 1];
            for (int j = 0, s = 0; j < m; j++) {
                s += list.get(j);
                sum[j + 1] = s;
            }
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int l = 1; l <= Integer.min(j, m); l++) {
                    dp[i][j] = Integer.max(dp[i][j], dp[i - 1][j - l] + sum[l]);
                }
            }
        }
        return dp[n][k];
    }

}
