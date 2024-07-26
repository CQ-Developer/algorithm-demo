package io.huhu.leetcode.dynamic.programming.medium.n494;

class DP implements Solution {

    @Override
    public int findTargetSumWays(int[] nums, int target) {
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        if (target < -s || target > s) {
            return 0;
        }
        int n = nums.length, m = s << 1;
        int[][] dp = new int[n + 1][m + 1];
        dp[n][target + s] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = -s; j <= s; j++) {
                if (j + nums[i] + s <= m) {
                    dp[i][j + s] += dp[i + 1][j + nums[i] + s];
                }
                if (j - nums[i] + s >= 0) {
                    dp[i][j + s] += dp[i + 1][j - nums[i] + s];
                }
            }
        }
        return dp[0][s];
    }

}
