package io.huhu.leetcode.dynamic.programming.medium.n322;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/coin-change/description/">零钱兑换</a>
 */
class Solution {

    public int coinChange(int[] coins, int amount) {
        // dp[i]是凑出金额i需要的最少硬币数量
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // 凑0元
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int c : coins) {
                // 注意i和c表示的是金额
                // 金额不能为负
                if (c <= i) {
                    // 如果选额当前硬币的金额c
                    // dp[i-c]表示加上金额c等于金额i的上次凑出的最少硬币数量
                    // 因为选择了金额为c的硬币, 所以要在上次的硬币数量后加1
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
