package io.huhu.leetcode.dynamic.programming.hard.n689;

/**
 * <a href="https://leetcode.cn/problems/maximum-sum-of-3-non-overlapping-subarrays/description/">
 * Maximum Sum of 3 Non-overlapping Subarrays
 * </a>
 */
interface Solution {

    /**
     * <li>1 <= nums.length <= 2 * 10<sup>4</sup></li>
     * <li>1 <= nums[i] <= 2<sup>16</sup></li>
     * <li>1 <= k <= floor(nums.length / 3)</li>
     */
    int[] maxSumOfThreeSubarrays(int[] nums, int k);

}
