package io.huhu.leetcode.dynamic.programming.medium.n213;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/house-robber-ii/description/">打家劫舍II</a>
 */
class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int a = doRob(Arrays.copyOfRange(nums, 0, n - 1));
        int b = doRob(Arrays.copyOfRange(nums, 1, n));
        return Math.max(a, b);
    }

    public int doRob(int[] nums) {
        int p = 0, c = 0;
        for (int n : nums) {
            int t = Math.max(c, p + n);
            p = c;
            c = t;
        }
        return c;
    }

}
