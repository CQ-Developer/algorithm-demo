package io.huhu.leetcode.dynamic.programming.medium.n322;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/coin-change/description/">零钱兑换</a>
 */
class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins.length == 1) {
            if (coins[0] > amount) {
                return -1;
            }
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            }
            return -1;
        }
        Arrays.sort(coins);
        int ans = 0;
        for (int i = coins.length - 1; i >= 0; ) {
            if (coins[i] > amount) {
                i--;
                continue;
            }
            amount -= coins[i];
            ans++;
        }
        return ans == 0 ? -1 : ans;
    }

}
