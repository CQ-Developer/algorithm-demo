package io.huhu.leetcode.dynamic.programming.medium.n486;

class DP implements Solution {

    @Override
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i] = nums[i];
            dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
        }
        dp[n - 1][n - 1] = nums[n - 1];
        for (int l = n - 3; l >= 0; l--) {
            for (int r = l + 2; r < n; r++) {
                int a = nums[l] + Math.min(dp[l + 1][r - 1], dp[l + 2][r]);
                int b = nums[r] + Math.min(dp[l + 1][r - 1], dp[l][r - 2]);
                dp[l][r] = Math.max(a, b);
            }
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return dp[0][n - 1] >= sum - dp[0][n - 1];
    }

}
