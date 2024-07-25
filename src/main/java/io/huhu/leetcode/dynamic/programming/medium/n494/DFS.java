package io.huhu.leetcode.dynamic.programming.medium.n494;

class DFS implements Solution {

    @Override
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, target);
    }

    private int dfs(int[] nums, int i, int j) {
        if (i == nums.length) {
            return j == 0 ? 1 : 0;
        }
        return dfs(nums, i + 1, j + nums[i]) + dfs(nums, i + 1, j - nums[i]);
    }

}
