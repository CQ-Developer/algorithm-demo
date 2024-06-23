package io.huhu.leetcode.dynamic.programming.medium.n416;

import java.util.Arrays;

/**
 * <h1>
 * <a href="https://leetcode.cn/problems/partition-equal-subset-sum/description/">Partition Equal Subset Sum</a>
 * </h1>
 * <p>
 * Given an integer array nums, return true if you can
 * partition the array into two subsets such that the sum
 * of the elements in both subsets is equal or false otherwise.
 * </p>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= nums.length <= 200</li>
     * <li>1 <= nums[i] <= 100</li>
     * </ul>
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int n = nums.length, avg = sum >> 1;
        int[][] mem = new int[n][avg + 1];
        for (int[] i : mem) {
            Arrays.fill(i, -1);
        }
        return dfs(nums, n - 1, avg, mem);
    }

    private boolean dfs(int[] nums, int i, int j, int[][] mem) {
        if (i < 0) {
            return j == 0;
        }
        if (mem[i][j] != -1) {
            return mem[i][j] == 1;
        }
        boolean ans = j >= nums[i] && dfs(nums, i - 1, j - nums[i], mem) || dfs(nums, i - 1, j, mem);
        mem[i][j] = ans ? 1 : 0;
        return ans;
    }

}
