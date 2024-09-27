package io.huhu.leetcode.n53;

class DP implements Code {

    @Override
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
