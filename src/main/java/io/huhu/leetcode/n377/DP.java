package io.huhu.leetcode.n377;

import java.util.Arrays;

class DP implements Code {

    @Override
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = nums[0]; i <= target; i++) {
            for (int j = 0; j < nums.length && i >= nums[j]; j++) {
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }

}
