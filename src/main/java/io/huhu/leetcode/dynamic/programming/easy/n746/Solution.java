package io.huhu.leetcode.dynamic.programming.easy.n746;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/description/">使用最小花费爬楼梯</a>
 */
class Solution {

    private final Map<Integer, Integer> cache = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dp(cost, 0), dp(cost, 1));
    }

    private int dp(int[] cost, int n) {
        if (n >= cost.length) {
            return 0;
        }
        int cached = cache.getOrDefault(n, -1);
        if (cached != -1) {
            return cached;
        }
        int min = Math.min(cost[n] + dp(cost, n + 1), cost[n] + dp(cost, n + 2));
        cache.put(n, min);
        return min;
    }

}
