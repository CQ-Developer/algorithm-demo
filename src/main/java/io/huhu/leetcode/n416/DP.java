package io.huhu.leetcode.n416;

class DP implements Code {

    @Override
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int n = sum >> 1;
        if (max > n) {
            return false;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = n; j >= num; j--) {
                if (dp[j - num]) {
                    dp[j] = true;
                }
            }
        }
        return dp[n];
    }

}
