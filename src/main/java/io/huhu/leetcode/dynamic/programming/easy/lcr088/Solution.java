package io.huhu.leetcode.dynamic.programming.easy.lcr088;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/GzCJIP/description/">使用最小花费爬楼梯</a>
 */
class Solution {

    public int minCostClimbingStairs(int[] cost) {
        return dfs(-1, cost, new HashMap<>());
    }

    private int dfs(int i, int[] cost, Map<Integer, Integer> cache) {
        if (i >= cost.length) {
            return 0;
        }
        int res = i == -1 ? 0 : cost[i];
        int a = cache.getOrDefault(i + 1, dfs(i + 1, cost, cache));
        int b = cache.getOrDefault(i + 2, dfs(i + 2, cost, cache));
        res += Math.min(a, b);
        return res;
    }

}
