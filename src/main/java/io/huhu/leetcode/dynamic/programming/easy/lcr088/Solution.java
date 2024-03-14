package io.huhu.leetcode.dynamic.programming.easy.lcr088;

/**
 * <a href="https://leetcode.cn/problems/GzCJIP/description/">使用最小花费爬楼梯</a>
 */
class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int pre = 0, cur = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(cur + cost[i - 1], pre + cost[i - 2]);
            pre = cur;
            cur = next;
        }
        return cur;
    }

}
