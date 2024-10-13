package io.huhu.leetcode.greedy.n1553;

/**
 * TODO: MLE
 */
class DP implements Code {

    @Override
    public int minDays(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int min = dp[i - 1];
            if (i % 2 == 0) {
                min = Math.min(min, dp[i / 2]);
            }
            if (i % 3 == 0) {
                min = Math.min(min, dp[i / 3]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

}
