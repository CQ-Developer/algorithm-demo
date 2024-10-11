package io.huhu.leetcode.n416;

class DP implements Code {

    @Override
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int n = nums.length, avg = sum >> 1;
        boolean[][] dp = new boolean[n][avg + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= avg; j++) {
            dp[0][j] = nums[0] == j;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= avg; j++) {
                dp[i][j] = j >= nums[i] && dp[i - 1][j - nums[i]] || dp[i - 1][j];
            }
        }
        return dp[n - 1][avg];
    }

}
