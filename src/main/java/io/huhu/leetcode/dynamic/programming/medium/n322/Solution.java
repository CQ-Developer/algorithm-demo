package io.huhu.leetcode.dynamic.programming.medium.n322;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/coin-change/description/">零钱兑换</a>
 */
class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        return dfs(coins, amount, new ArrayList<>(), 0);
    }

    private int dfs(int[] coins, int amount, List<Integer> path, long sum) {
        if (sum == amount) {
            return path.size();
        }
        if (sum > amount) {
            return -1;
        }
        int ans = -1;
        for (int i = coins.length - 1; i >= 0; i--) {
            path.addLast(coins[i]);
            int cur = dfs(coins, amount, path, sum + coins[i]);
            path.removeLast();
            if (cur == -1) {
                continue;
            }
            if (ans == -1) {
                ans = cur;
            } else {
                ans = Math.min(ans, cur);
            }
        }
        return ans;
    }

}
