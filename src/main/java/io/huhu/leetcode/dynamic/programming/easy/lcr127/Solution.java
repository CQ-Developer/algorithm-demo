package io.huhu.leetcode.dynamic.programming.easy.lcr127;

/**
 * <a href="https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/description/">跳跃训练</a>
 */
class Solution {

    public int trainWays(int num) {
        if (num < 2) {
            return 1;
        }
        int[] dp = new int[num + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[num];
    }

}
