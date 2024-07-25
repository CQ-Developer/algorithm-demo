package io.huhu.leetcode.dynamic.programming.medium.n494;

class DFS implements Solution {

    @Override
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, m = 0;
        for (int num : nums) {
            m += num;
        }
        int[][] f = new int[n][m * 2 + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < f[i].length; j++) {
                f[i][j] = -1;
            }
        }
        return dfs(nums, 0, target, 0, f, m);
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
