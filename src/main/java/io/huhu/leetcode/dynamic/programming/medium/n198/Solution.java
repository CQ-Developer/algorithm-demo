package io.huhu.leetcode.dynamic.programming.medium.n198;

/**
 * <a href="https://leetcode.cn/problems/house-robber/description/">
 * House Robber
 * </a>
 */
class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 1];
        f[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            f[i] = Integer.max(f[i - 1], nums[i - 1] + f[i - 2]);
        }
        return f[n];
    }

}
