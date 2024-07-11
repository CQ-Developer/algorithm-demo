package io.huhu.leetcode.dynamic.programming.medium.n198;

/**
 * <a href="https://leetcode.cn/problems/house-robber/description/">
 * House Robber
 * </a>
 */
class Solution {

    public int rob(int[] nums) {
        int p = 0, c = 0;
        for (int num : nums) {
            int t = Integer.max(c, p + num);
            p = c;
            c = t;
        }
        return c;
    }

}
