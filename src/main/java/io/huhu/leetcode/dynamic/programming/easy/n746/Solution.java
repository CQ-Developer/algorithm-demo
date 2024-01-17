package io.huhu.leetcode.dynamic.programming.easy.n746;

/**
 * <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/description/">使用最小花费爬楼梯</a>
 */
class Solution {


    public int minCostClimbingStairs(int[] cost) {
        return dp(cost, cost.length);
    }

    private int dp(int[] cost, int n) {
        if (n < 2) {
            return 0;
        }
        int a = n - 1, b = n - 2;
        if (cost[a] < cost[b]) {
            return cost[a] + dp(cost, a);
        }
        if (cost[b] < cost[a]) {
            return cost[b] + dp(cost, b);
        }
        return Math.min(cost[a] + dp(cost, a), cost[b] + dp(cost, b));
    }

}
