package io.huhu.leetcode.dynamic.programming.medium.n198;

/**
 * <a href="https://leetcode.cn/problems/house-robber/description/">打家劫舍</a>
 */
class Solution {

    /**
     * <pre>{@code
     * public int rob(int[] nums) {
     *     int[] dp = new int[nums.length + 1];
     *     dp[0] = 0;
     *     dp[1] = nums[0];
     *     for (int i = 2; i < dp.length; i++) {
     *         dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
     *     }
     *     return dp[nums.length];
     * }
     * }</pre>
     */
    public int rob(int[] nums) {
        int p = 0, c = 0;
        for (int num : nums) {
            int t = Math.max(c, p + num);
            p = c;
            c = t;
        }
        return c;
    }

}
