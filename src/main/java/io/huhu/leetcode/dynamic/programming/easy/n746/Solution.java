package io.huhu.leetcode.dynamic.programming.easy.n746;

/**
 * <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/description/">使用最小花费爬楼梯</a>
 */
class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[n];
    }

}
