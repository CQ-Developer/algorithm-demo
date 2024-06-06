package io.huhu.leetcode.classic.ugly.number.n264;

/**
 * <a href="https://leetcode.cn/problems/ugly-number-ii/">丑数II</a>
 */
class Solution {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int dp2 = dp[a] * 2, dp3 = dp[b] * 3, dp5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(dp2, dp3), dp5);
            if (dp[i] == dp2) {
                a++;
            }
            if (dp[i] == dp3) {
                b++;
            }
            if (dp[i] == dp5) {
                c++;
            }
        }
        return dp[n - 1];
    }
}
