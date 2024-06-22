package io.huhu.leetcode.dynamic.programming.medium.n416;

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
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        return backTracing(nums, 0, sum >> 1);
    }

    private boolean backTracing(int[] nums, int i, int n) {
        if (n == 0) {
            return true;
        }
        if (i == nums.length) {
            return false;
        }
        return backTracing(nums, i + 1, n) || backTracing(nums, i + 1, n - nums[i]);
    }

}
