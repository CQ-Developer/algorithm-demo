package io.huhu.leetcode.dynamic.programming.medium.n353;

/**
 * <h1><a href="https://leetcode.cn/problems/integer-break/description/">Integer Break</a></h1>
 */
class Solution {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        // can't break 0 and 1
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                // !Note: number i can break into j + (i - j)
                // if number i - j can't break, the maximize product is j * (i - j)
                // if number i - j can break, the previous maximize product is dp[i - j],
                // so the current maximize product is j * dp[i - j]
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

}
