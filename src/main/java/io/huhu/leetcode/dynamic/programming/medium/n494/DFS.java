package io.huhu.leetcode.dynamic.programming.medium.n494;

class DFS implements Solution {

    @Override
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, target);
    }

    private int dfs(int[] nums, int i, int target) {
        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }
        return dfs(nums, i + 1, target + nums[i]) + dfs(nums, i + 1, target - nums[i]);
    }

}
