package io.huhu.leetcode.dynamic.programming.sumary.house.robber.n213;

/**
 * <a href="https://leetcode.cn/problems/house-robber-ii/description/">打家劫舍II</a>
 */
class Solution {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int a = rob(nums, 0, nums.length - 1);
        int b = rob(nums, 1, nums.length);
        return Math.max(a, b);
    }

    private int rob(int[] nums, int s, int e) {
        int p = 0, c = nums[s];
        for (int i = s + 1; i < e; i++) {
            int t = Math.max(c, p + nums[i]);
            p = c;
            c = t;
        }
        return c;
    }

}
