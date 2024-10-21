package io.huhu.leetcode.n740;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int deleteAndEarn(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n = Math.max(n, num);
        }
        int[] earns = new int[n + 1];
        for (int num : nums) {
            earns[num] += num;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(earns, 0, dp);
    }

    private int f(int[] nums, int i, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        return dp[i] = Math.max(f(nums, i + 1, dp), f(nums, i + 2, dp) + nums[i]);
    }

}
