package io.huhu.leetcode.n300;

class DFS implements Code {

    @Override
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, f(nums, i, dp));
        }
        return ans;
    }

    private int f(int[] nums, int i, int[] dp) {
        if (dp[i] != 0) {
            return dp[i];
        }
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                dp[i] = Math.max(dp[i], f(nums, j, dp));
            }
        }
        return ++dp[i];
    }

}
