package io.huhu.leetcode.dynamic.programming.medium.n198;

/**
 * <a href="https://leetcode.cn/problems/house-robber/description/">打家劫舍</a>
 */
class Solution {

    public int rob(int[] nums) {
        int n1 = 0;
        for (int i = 0; i < nums.length; i += 2) {
            n1 += nums[i];
        }
        int n2 = 0;
        for (int i = 1; i < nums.length; i += 2) {
            n2 += nums[i];
        }
        return Math.max(n1, n2);
    }

}
