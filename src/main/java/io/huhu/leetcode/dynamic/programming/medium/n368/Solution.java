package io.huhu.leetcode.dynamic.programming.medium.n368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
     * <li>1 <= nums[i] <= 2* 10<sup>9</sup></li>
     * <li>All the integers in nums are unique.</li>
     * </ul>
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer>[] dp = new List[nums.length];
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            dp[i] = list;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j].size() + 1 > dp[i].size()) {
                    dp[i].clear();
                    dp[i].addAll(dp[j]);
                    dp[i].add(nums[i]);
                }
            }
        }
        int i = 0;
        for (int j = 1; j < dp.length; j++) {
            if (dp[j].size() > dp[i].size()) {
                i = j;
            }
        }
        return dp[i];
    }

}
