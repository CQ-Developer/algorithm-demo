package io.huhu.leetcode.n416;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        if (max > target) {
            return false;
        }
        Arrays.sort(nums);
        int n = nums.length;
        return f(nums, n - 1, target, new int[n][target + 1]);
    }

    private boolean f(int[] nums, int i, int target, int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (i == 0) {
            return nums[i] == target;
        }
        if (dp[i][target] != 0) {
            return dp[i][target] == 1;
        }
        boolean ans = target >= nums[i] && f(nums, i - 1, target - nums[i], dp) || f(nums, i - 1, target, dp);
        dp[i][target] = ans ? 1 : -1;
        return ans;
    }

}
