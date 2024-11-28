package io.huhu.leetcode.n1696;

import io.huhu.TLE;

import java.util.Arrays;

@TLE
class Memoization implements Code {

    @Override
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return f(nums, k, dp, n - 1);
    }

    private int f(int[] nums, int k, int[] dp, int i) {
        if (i == 0) {
            return nums[0];
        }
        if (dp[i] != Integer.MIN_VALUE) {
            return dp[i];
        }
        int ans = Integer.MIN_VALUE;
        for (int j = Math.max(0, i - k); j < i; j++) {
            ans = Math.max(ans, f(nums, k, dp, j));
        }
        return dp[i] = ans + nums[i];
    }

}
