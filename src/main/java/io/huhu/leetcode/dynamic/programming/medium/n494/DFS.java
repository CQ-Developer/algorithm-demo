package io.huhu.leetcode.dynamic.programming.medium.n494;

import java.util.Arrays;

class DFS implements Solution {

    @Override
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[][] f = new int[nums.length][sum * 2 + 1];
        for (int[] a : f) {
            Arrays.fill(a, -1);
        }
        return dfs(nums, 0, target, 0, f, sum);
    }

    private int dfs(int[] nums, int i, int target, int j, int[][] f, int m) {
        if (i == nums.length) {
            return j == target ? 1 : 0;
        }
        if (f[i][m + j] != -1) {
            return f[i][m + j];
        }
        return f[i][m + j] = dfs(nums, i + 1, target, j + nums[i], f, m) + dfs(nums, i + 1, target, j - nums[i], f, m);
    }

}
