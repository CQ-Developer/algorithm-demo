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
        int n = sum >> 1;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = n; j >= 1; j--) {
                if (j >= num && dp[j - num]) {
                    dp[j] = true;
                }
            }
        }
        return dp[n];
    }

}
