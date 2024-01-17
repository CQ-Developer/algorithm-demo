package io.huhu.leetcode.dynamic.programming.easy.n70;

/**
 * <a href="https://leetcode.cn/problems/climbing-stairs/description/">爬楼梯</a>
 */
class Solution {

    /**
     * 动态规划
     */
    public int climbStairs(int n) {
        int[] table = new int[n + 1];
        table[0] = 1;
        table[1] = 2;
        for (int i = 2; i < n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n - 1];
    }

}
