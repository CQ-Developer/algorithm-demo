package io.huhu.leetcode.dynamic.programming.medium.n213;

import java.util.Arrays;

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
        int a = doRob(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int b = doRob(Arrays.copyOfRange(nums, 1, nums.length));
        return Integer.max(a, b);
    }

    private int doRob(int[] nums) {
        int p = 0, c = 0;
        for (int n : nums) {
            int t = Integer.max(c, n + p);
            p = c;
            c = t;
        }
        return c;
    }

}
