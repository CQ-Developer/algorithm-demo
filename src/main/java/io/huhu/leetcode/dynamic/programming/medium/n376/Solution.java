package io.huhu.leetcode.dynamic.programming.medium.n376;

/**
 * <a href="https://leetcode.cn/problems/wiggle-subsequence/description/">Wiggle Subsequence</a>
 */
class Solution {

    /**
     * 1 <= nums.length <= 1000
     * 0 <= nums[i] <= 1000
     */
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        if (n == 2 && nums[0] == nums[1]) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3, j = i - 1; i < n + 1; i++, j++) {
            int a = nums[j - 2], b = nums[j - 1], c = nums[j];
            if ((a > b && c > b) || (a < b && c < b)) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }

}
