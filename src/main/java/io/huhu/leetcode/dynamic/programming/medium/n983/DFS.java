package io.huhu.leetcode.dynamic.programming.medium.n983;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-cost-for-tickets/description/">Minimum Cost For Tickets</a>
 */
class DFS implements Solution {

    @Override
    public int mincostTickets(int[] days, int[] costs) {
        int[] mem = new int[days.length];
        Arrays.fill(mem, -1);
        return dfs(days, costs, new int[]{1, 7, 30}, 0, mem);
    }

    private int dfs(int[] days, int[] costs, int[] duration, int i, int[] dp) {
        if (i == days.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = 0, j = i; k < costs.length; k++) {
            while (j < days.length && days[i] + duration[k] > days[j]) {
                j++;
            }
            ans = Math.min(ans, costs[k] + dfs(days, costs, duration, j, dp));
        }
        return dp[i] = ans;
    }

}
