package io.huhu.leetcode.dynamic.programming.medium.n322;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/coin-change/description/">零钱兑换</a>
 */
class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int c : coins) {
            for (int j = c; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - c] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
