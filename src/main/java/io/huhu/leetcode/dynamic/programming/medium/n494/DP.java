package io.huhu.leetcode.dynamic.programming.medium.n494;

class DP implements Solution {

    @Override
    public int findTargetSumWays(int[] nums, int target) {
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        if (s < target || ((target & 1) ^ (s & 1)) == 1) {
            return 0;
        }
        int n = nums.length, m = (target + s) >> 1;
        if (m < 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][m];
    }

}
