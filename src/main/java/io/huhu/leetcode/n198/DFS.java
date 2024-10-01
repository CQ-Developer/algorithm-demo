package io.huhu.leetcode.n198;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return f(nums, 0, dp);
    }

    private int f(int[] nums, int i, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int a = f(nums, i + 1, dp);
        int b = f(nums, i + 2, dp) + nums[i];
        return dp[i] = Math.max(a, b);
    }

}
