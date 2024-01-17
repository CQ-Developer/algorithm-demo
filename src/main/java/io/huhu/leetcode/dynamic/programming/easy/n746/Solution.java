package io.huhu.leetcode.dynamic.programming.easy.n746;

/**
 * <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/description/">使用最小花费爬楼梯</a>
 */
class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0;
        for (int i = 2; i <= cost.length; i++) {
            int c = Math.min(a + cost[i - 2], b + cost[i - 1]);
            a = b;
            b = c;
        }
        return b;
    }

}
