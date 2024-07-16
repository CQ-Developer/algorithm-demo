package io.huhu.leetcode.dynamic.programming.medium.n300;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/description/">
 * Longest Increasing Subsequence
 * </a>
 */
class Solution {

    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int[] f = new int[nums.length];
        for (int i = 0; i < f.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Integer.max(f[i], f[j] + 1);
                }
            }
            ans = Integer.max(ans, f[i]);
        }
        return ans;
    }

}
