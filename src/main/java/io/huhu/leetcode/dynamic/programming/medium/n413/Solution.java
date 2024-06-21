package io.huhu.leetcode.dynamic.programming.medium.n413;

/**
 * <h1>
 * <a href="https://leetcode.cn/problems/arithmetic-slices/description/">Arithmetic Slices</a>
 * </h1>
 * <p>
 * An integer array is called arithmetic if it consists of at least
 * three elements and if the difference between any two consecutive
 * element is same.
 * </p>
 * <p>
 * For example, [1,3,5,7,9], [7,7,7,7],
 * and [3,-1,-5,-9] are arithmetic sequence.
 * </p>
 * <p>
 * Given an integer array nums, return the number
 * of arithmetic subarrays of nums.
 * </p>
 * <p>
 * A subarray is a contiguous subsequence of the array.
 * </p>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= nums.length <= 5000</li>
     * <li>-1000 <= nums[i] <= 1000</li>
     * </ul>
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0, dp = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp += 1;
                ans += dp;
            } else {
                dp = 0;
            }
        }
        return ans;
    }

}
