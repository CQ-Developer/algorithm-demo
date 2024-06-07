package io.huhu.leetcode.dynamic.programming.medium.n368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/largest-divisible-subset/description/">Largest Divisible Subset</a>
 */
class Solution {

    /**
     * <p>give a set of distinct positive integers nums,
     * return the largest subset answer such that every pair
     * {answer[i], answer[j]} of elements in this subset satisfies:</p>
     * <ul>
     * <li>answer[i] % answer[j] == 0</li>
     * or
     * <li>answer[j] % answer[i] == 0</li>
     * </ul>
     * <p>if there are multiple solutions,
     * return any of them.</p>
     * <ul>
     * <li>1 <= nums.length <= 1000</li>
     * <li>1 <= nums[i] <= 2 * 10<sup>9</sup></li>
     * <li>All the integers in nums are unique.</li>
     * </ul>
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 1, maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; nums[j] <= nums[i] >> 1; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i--) {
            if (maxLen == dp[i] && nums[maxIndex] % nums[i] == 0) {
                res.add(nums[i]);
                maxLen--;
                maxIndex = i;
            }
        }
        return res;
    }

}
