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
        // 计算数组元素的和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果不是偶数, 那么一定不能平分, 返回false
        if ((sum & 1) == 1) {
            return false;
        }
        // 使用动态规划求解
        int n = nums.length, x = sum >> 1;
        boolean[] dp = new boolean[x + 1];
        dp[0] = true;
        if (nums[0] < x) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = x; j >= 0 && nums[i] <= j; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
            if (dp[x]) {
                return true;
            }
        }
        return dp[x];
    }

}
