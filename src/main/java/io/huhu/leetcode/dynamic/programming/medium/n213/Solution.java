package io.huhu.leetcode.dynamic.programming.medium.n213;

/**
 * <a href="https://leetcode.cn/problems/house-robber-ii/description/">
 * House Robber II
 * </a>
 */
class Solution {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int a = doRob(nums, 0, nums.length - 2);
        int b = doRob(nums, 1, nums.length - 1);
        return Integer.max(a, b);
    }

    private int doRob(int[] nums, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            return nums[l];
        }
        if (l + 1 == r) {
            return Integer.max(nums[l], nums[r]);
        }
        int p = 0, c = 0;
        while (l <= r) {
            int t = Integer.max(c, nums[l++] + p);
            p = c;
            c = t;
        }
        return c;
    }

}
