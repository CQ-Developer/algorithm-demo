package io.huhu.leetcode.dynamic.programming.medium.n300;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/description/">
 * Longest Increasing Subsequence
 * </a>
 */
class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] ends = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int j = binarySearch(ends, len, nums[i]);
            if (j == -1) {
                ends[len++] = nums[i];
            } else {
                ends[j] = nums[i];
            }
        }
        return len;
    }

    private int binarySearch(int[] ends, int len, int num) {
        int l = 0, r = len - 1, ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (num <= ends[m]) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

}
