package io.huhu.leetcode.divide.and.conquer.medium.n53;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/description/">最大子数组和</a>
 */
class Solution {

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }

}
