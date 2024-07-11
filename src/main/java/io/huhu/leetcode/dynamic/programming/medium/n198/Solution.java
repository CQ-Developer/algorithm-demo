package io.huhu.leetcode.dynamic.programming.medium.n198;

/**
 * <a href="https://leetcode.cn/problems/house-robber/description/">
 * House Robber
 * </a>
 */
class Solution {

    public int rob(int[] nums) {
        int ans = nums[0];
        for (int i = 2, p1 = nums[0], p2 = 0; i <= nums.length; i++) {
            ans = Integer.max(p1, nums[i - 1] + p2);
            p2 = p1;
            p1 = ans;
        }
        return ans;
    }

}
