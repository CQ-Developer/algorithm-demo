package io.huhu.leetcode.dynamic.programming.medium.n343;

/**
 * <h1><a href="https://leetcode.cn/problems/integer-break/description/">Integer Break</a></h1>
 */
class Solution {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < (i >> 1) + 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

}
