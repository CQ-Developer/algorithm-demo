package io.huhu.leetcode.dynamic.programming.medium.n377;

/**
 * <h1>
 * <a href="https://leetcode.cn/problems/combination-sum-iv/description/">Combination Sum IV</a>
 * </h1>
 * <p>Given an array of distinct integers nums and a target integer target,
 * return the number of possible combinations that add up to target.</p>
 * <p>The test cases are generated so that the answer can fit in a 32-bit integer.</p>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= nums.length <= 200</li>
     * <li>1 <= nums[i] <= 1000</li>
     * <li>1 <= target <= 1000</li>
     * <li>All the elements of nums are unique</li>
     * </ul>
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j : nums) {
                if (j <= i) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[target];
    }

}
