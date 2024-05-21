package io.huhu.leetcode.dynamic.programming.medium.n198;

/**
 * <a href="https://leetcode.cn/problems/house-robber/description/">打家劫舍</a>
 */
class Solution {

    public int rob(int[] nums) {
        int p = 0, c = 0;
        for (int num : nums) {
            int t = Math.max(c, p + num);
            p = c;
            c = t;
        }
        return c;
    }

}
