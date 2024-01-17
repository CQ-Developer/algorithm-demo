package io.huhu.leetcode.dynamic.programming.easy.n70;

/**
 * <a href="https://leetcode.cn/problems/climbing-stairs/description/">爬楼梯</a>
 */
class Solution {

    /**
     * 动态规划
     */
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int x = 1, y = 2, z = 3;
        for (int i = 4; i <= n; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return z;
    }

}
