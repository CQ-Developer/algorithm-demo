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
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = nums[i];
        }
        int k = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; nums[j] <= nums[i] >> 1; j++) {
                if (nums[i] % nums[j] == 0 && dp[j][0] + 1 > dp[i][0]) {
                    System.arraycopy(dp[j], 1, dp[i], 1, dp[j][0]);
                    dp[i][dp[j][0] + 1] = nums[i];
                    dp[i][0] = dp[j][0] + 1;
                }
            }
            if (dp[i][0] > dp[k][0]) {
                k = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int j = 1; j <= dp[k][0]; j++) {
            ans.add(dp[k][j]);
        }
        return ans;
    }

}
