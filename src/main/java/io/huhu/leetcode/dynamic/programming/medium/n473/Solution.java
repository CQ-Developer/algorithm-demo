package io.huhu.leetcode.dynamic.programming.medium.n473;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/matchsticks-to-square/description/">
 * Matchsticks to Square
 * </a>
 */
class Solution {

    public boolean makesquare(int[] matchsticks) {
        int total = sum(matchsticks);
        if (total % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        return f(matchsticks, total >> 2, (1 << matchsticks.length) - 1, 0, 4, new int[1 << matchsticks.length]);
    }

    private boolean f(int[] matchsticks, int target, int status, int cur, int rest, int[] dp) {
        if (rest == 0) {
            return status == 0;
        }
        if (dp[status] != 0) {
            return dp[status] == 1;
        }
        boolean ans = false;
        for (int i = matchsticks.length - 1; i >= 0; i--) {
            if (((1 << i) & status) != 0 && cur + matchsticks[i] <= target) {
                if (cur + matchsticks[i] == target) {
                    ans = f(matchsticks, target, status ^ (1 << i), 0, rest - 1, dp);
                } else {
                    ans = f(matchsticks, target, status ^ (1 << i), cur + matchsticks[i], rest, dp);
                }
                if (ans) {
                    break;
                }
            }
        }
        dp[status] = ans ? 1 : -1;
        return ans;
    }

    private int sum(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        return sum;
    }

}
