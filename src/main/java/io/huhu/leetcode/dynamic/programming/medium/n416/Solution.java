package io.huhu.leetcode.dynamic.programming.medium.n416;

import java.util.Arrays;

/**
 * <h1>
 * <a href="https://leetcode.cn/problems/partition-equal-subset-sum/description/">Partition Equal Subset Sum</a>
 * </h1>
 * <p>
 * Given an integer array nums, return true if you can
 * partition the array into two subsets such that the sum
 * of the elements in both subsets is equal or false otherwise.
 * </p>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= nums.length <= 200</li>
     * <li>1 <= nums[i] <= 100</li>
     * </ul>
     */
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        return backTracing(nums, new boolean[nums.length], sum >> 1);
    }

    private boolean backTracing(int[] nums, boolean[] used, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (n < nums[i]) {
                break;
            }
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            if (backTracing(nums, used, n - nums[i])) {
                return true;
            }
            used[i] = false;
        }
        return false;
    }

}
