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
        int n = nums.length, m = sum >> 1;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        if (nums[0] <= m) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = m; j > 0; j--) {
                dp[j] = dp[j] || (nums[i] <= j && dp[j - nums[i]]);
            }
            if (dp[m]) {
                return true;
            }
        }
        return dp[m];
    }

}
