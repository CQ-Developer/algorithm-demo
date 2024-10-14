package io.huhu.leetcode.n494;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        int[][] dp = new int[n][sum * 2 + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return f(nums, 0, target, 0, dp, sum);
    }

    private int f(int[] nums, int i, int target, int cur, int[][] dp, int offset) {
        if (i == nums.length) {
            return cur == target ? 1 : 0;
        }
        int j = cur + offset;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int a = f(nums, i + 1, target, cur + nums[i], dp, offset);
        int b = f(nums, i + 1, target, cur - nums[i], dp, offset);
        return dp[i][j] = a + b;
    }

}
