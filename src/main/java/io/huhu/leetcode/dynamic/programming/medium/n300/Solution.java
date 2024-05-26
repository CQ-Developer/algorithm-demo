package io.huhu.leetcode.dynamic.programming.medium.n300;

class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            max = Math.max(max, ++dp[i]);
        }
        return max;
    }

}
