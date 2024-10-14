package io.huhu.leetcode.n486;

class DP implements Code {

    @Override
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        // dp[l][r]表示p1玩家在l...r范围上获取的最高得分
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i] = nums[i];
            dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
        }
        dp[n - 1][n - 1] = nums[n - 1];
        for (int l = n - 3; l >= 0; l--) {
            for (int r = l + 2; r < n; r++) {
                dp[l][r] = Math.max(
                        Math.min(dp[l + 2][r], dp[l + 1][r - 1]) + nums[l],
                        Math.min(dp[l][r - 2], dp[l + 1][r - 1]) + nums[r]);
            }
        }
        int p1 = dp[0][n - 1];
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return p1 >= sum - p1;
    }

}
