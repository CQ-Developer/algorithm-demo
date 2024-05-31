package io.huhu.leetcode.dynamic.programming.sumary.house.robber.n198;

/**
 * <a href="https://leetcode.cn/problems/house-robber/description/">打家劫舍</a>
 */
class Solution {

    public int rob(int[] nums) {
        int p = 0, c = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int t = Math.max(c, p + nums[i]);
            p = c;
            c = t;
        }
        return c;
    }

}
