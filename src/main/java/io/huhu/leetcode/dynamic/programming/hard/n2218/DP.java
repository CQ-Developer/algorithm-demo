package io.huhu.leetcode.dynamic.programming.hard.n2218;

import java.util.List;

class DP implements Solution {

    @Override
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] dp = new int[k + 1];
        for (List<Integer> pile : piles) {
            int n = Integer.min(pile.size(), k);
            int[] sum = new int[n + 1];
            for (int j = 0, s = 0; j < n; j++) {
                sum[j + 1] = s += pile.get(j);
            }
            for (int j = k; j > 0; j--) {
                for (int l = 1; l <= Integer.min(j, n); l++) {
                    dp[j] = Integer.max(dp[j], dp[j - l] + sum[l]);
                }
            }
        }
        return dp[k];
    }

}
