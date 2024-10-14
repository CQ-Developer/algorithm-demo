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
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int k : nums) {
            for (int j = m; j >= k; j--) {
                dp[j] += dp[j - k];
            }
        }
        return dp[m];
    }

}
