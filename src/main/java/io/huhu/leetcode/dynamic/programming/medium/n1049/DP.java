package io.huhu.leetcode.dynamic.programming.medium.n1049;

class DP implements Solution {

    @Override
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int n = stones.length, m = sum >> 1;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - stones[i - 1] >= 0) {
                    dp[i][j] = Integer.max(dp[i][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        return sum - dp[n][m] - dp[n][m];
    }

}
