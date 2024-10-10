package io.huhu.leetcode.n377;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        Arrays.sort(nums);
        return f(nums, target, dp);
    }

    /**
     * 每一轮可以选择所有数字
     */
    private int f(int[] nums, int target, int[] dp) {
        if (target == 0) {
            return 1;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        dp[target] = 0;
        for (int i = 0; i < nums.length && nums[i] <= target; i++) {
            dp[target] += f(nums, target - nums[i], dp);
        }
        return dp[target];
    }

}
