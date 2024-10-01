package io.huhu.leetcode.n213;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int a = f(nums, 0, 0, n - 2, dp);
        Arrays.fill(dp, -1);
        int b = f(nums, 1, 1, n - 1, dp);
        return Math.max(a, b);
    }

    private int f(int[] nums, int l, int i, int r, int[] dp) {
        if (i == r) {
            return nums[i];
        }
        if (i > r) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int a = f(nums, l, i + 1, r, dp);
        int b = f(nums, l, i + 2, r, dp) + nums[i];
        return dp[i] = Math.max(a, b);
    }

}
