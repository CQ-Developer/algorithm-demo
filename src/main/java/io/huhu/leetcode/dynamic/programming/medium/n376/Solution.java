package io.huhu.leetcode.dynamic.programming.medium.n376;

/**
 * <a href="https://leetcode.cn/problems/wiggle-subsequence/description/">Wiggle Subsequence</a>
 */
class Solution {

    /**
     * 1 <= nums.length <= 1000
     * 0 <= nums[i] <= 1000
     */
    public int wiggleMaxLength(int[] nums) {
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

}
