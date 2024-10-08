package io.huhu.leetcode.n322;

import java.util.Arrays;

class DP implements Code {

    @Override
    public int coinChange(int[] coins, int amount) {
        // dp[i]表示凑到金额i需要的最少硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
