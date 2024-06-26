package io.huhu.leetcode.dynamic.programming.medium.n473;

import java.util.Arrays;

/**
 * <h1>
 * <a href="https://leetcode.cn/problems/matchsticks-to-square/description/">Matchsticks to Square</a>
 * </h1>
 * <p>You are given an integer array matchsticks where matchsticks[i] is the length
 * of the i<sub>th</sub> matchstick. You want to use all the matchsticks to make
 * one square. You should not break any stick, but you can link them up, and each
 * matchstick must be used exactly one time.</p>
 * <p>Return true if you can make this square and false otherwise.</p>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= matchsticks.length <= 15</li>
     * <li>1 <= matchsticks[i] <= 10<sup>8</sup></li>
     * </ul>
     */
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int len = sum >> 2, n = matchsticks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int s = 1; s < dp.length; s++) {
            for (int k = 0; k < n; k++) {
                if ((s & (1 << k)) == 0) {
                    // s的第k位为0表示表示第k根火柴未被放入
                    continue;
                }
                // TODO ?
                int s1 = s & ~(1 << k);
                if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                    break;
                }
            }
        }
        return dp[dp.length - 1] == 0;
    }

}
