package io.huhu.leetcode.dynamic.programming.easy.lcr088;

/**
 * <a href="https://leetcode.cn/problems/GzCJIP/description/">使用最小花费爬楼梯</a>
 */
class Solution {

    public int minCostClimbingStairs(int[] cost) {
        return dfs(-1, cost);
    }

    private int dfs(int i, int[] cost) {
        if (i >= cost.length) {
            return 0;
        }
        int res = i == -1 ? 0 : cost[i];
        res += Math.min(dfs(i + 1, cost), dfs(i + 2, cost));
        return res;
    }

}
