package io.huhu.leetcode.dynamic.programming.medium.n698;

import java.util.Arrays;

class DFS implements Solution {

    @Override
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int target = sum(nums);
        if (target % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        return f(nums, target / k, (1 << nums.length) - 1, 0, k, new int[1 << nums.length]);
    }

    private boolean f(int[] nums, int target, int status, int cur, int k, int[] dp) {
        if (k == 0) {
            return status == 0;
        }
        if (dp[status] != 0) {
            return dp[status] == 1;
        }
        boolean ans = false;
        for (int i = nums.length - 1; i >= 0 && !ans; i--) {
            if ((status & (1 << i)) != 0 && cur + nums[i] <= target) {
                if (cur + nums[i] == target) {
                    ans = f(nums, target, status ^ (1 << i), 0, k - 1, dp);
                } else {
                    ans = f(nums, target, status ^ (1 << i), cur + nums[i], k, dp);
                }
            }
        }
        dp[status] = ans ? 1 : -1;
        return ans;
    }

    private int sum(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans += num;
        }
        return ans;
    }

}
