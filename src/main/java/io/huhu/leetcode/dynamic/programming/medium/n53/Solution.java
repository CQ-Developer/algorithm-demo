package io.huhu.leetcode.dynamic.programming.medium.n53;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/description/">最大子数组和</a>
 */
class Solution {

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

}
