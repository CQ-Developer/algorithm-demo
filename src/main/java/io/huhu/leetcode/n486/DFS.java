package io.huhu.leetcode.n486;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int p1 = f(nums, 0, n - 1, dp);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return p1 >= sum - p1;
    }

    private int f(int[] nums, int l, int r, int[][] dp) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        int x = f(nums, l + 1, r - 1, dp);
        int a = Math.min(f(nums, l + 2, r, dp), x) + nums[l];
        int b = Math.min(f(nums, l, r - 2, dp), x) + nums[r];
        return dp[l][r] = Math.max(a, b);
    }

}
