package io.huhu.leetcode.dynamic.programming.medium.n53;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/description/">
 * Maximum Subarray
 * </a>
 */
class Solution {

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + nums[i] > nums[i]) {
                nums[i] += nums[i - 1];
            }
            if (nums[i] > ans) {
                ans = nums[i];
            }
        }
        return ans;
    }

}
