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
        int m = (target + s) >> 1;
        if (m < 0) {
            return 0;
        }
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = m; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[m];
    }

}
