package io.huhu.leetcode.n494;

class DP implements Code {

    @Override
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int m = sum - target;
        if (m < 0 || ((m & 1) == 1)) {
            return 0;
        }
        m >>= 1;
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int k = nums[i - 1];
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= k) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        return dp[n][m];
    }

}
