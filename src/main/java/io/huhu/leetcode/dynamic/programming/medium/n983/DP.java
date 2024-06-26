package io.huhu.leetcode.dynamic.programming.medium.n983;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-cost-for-tickets/description/">Minimum Cost For Tickets</a>
 */
class DP implements Solution {

    @Override
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[366], duration = {1, 7, 30};
        Arrays.fill(dp, 0, n + 1, Integer.MAX_VALUE);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0, j = i; k < costs.length; k++) {
                while (j < days.length && days[i] + duration[k] > days[j]) {
                    j++;
                }
                dp[i] = Math.min(dp[i], costs[k] + dp[j]);
            }
        }
        return dp[0];
    }

}
