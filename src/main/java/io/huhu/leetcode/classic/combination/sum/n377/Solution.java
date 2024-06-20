package io.huhu.leetcode.classic.combination.sum.n377;

import java.util.Arrays;

/**
 * <h1>
 * <a href="https://leetcode.cn/problems/combination-sum-iv/description/">Combination Sum IV</a>
 * </h1>
 * <p>Given an array of distinct integers nums and a target integer target,
 * return the number of possible combinations that add up to target.</p>
 * <p>The test cases are generated so that the answer can fit in a 32-bit integer.</p>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= nums.length <= 200</li>
     * <li>1 <= nums[i] <= 1000</li>
     * <li>1 <= target <= 1000</li>
     * <li>All the elements of nums are unique</li>
     * </ul>
     */
    public int combinationSum4(int[] nums, int target) {
        int[] cache = new int[target + 1];
        Arrays.fill(cache, -1);
        return backtrace(nums, target, cache);
    }

    private int backtrace(int[] nums, int target, int[] cache) {
        if (target == 0) {
            return 1;
        }
        if (cache[target] != -1) {
            return cache[target];
        }
        int result = 0;
        for (int num : nums) {
            if (num <= target) {
                result += backtrace(nums, target - num, cache);
            }
        }
        return cache[target] = result;
    }

}
