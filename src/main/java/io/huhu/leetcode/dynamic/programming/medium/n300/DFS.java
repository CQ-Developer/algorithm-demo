package io.huhu.leetcode.dynamic.programming.medium.n300;

class DFS implements Solution {

    @Override
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Integer.max(ans, dfs(nums, i));
        }
        return ans;
    }

    private int dfs(int[] nums, int i) {
        int ans = 0;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                ans = Integer.max(ans, dfs(nums, j));
            }
        }
        return ans + 1;
    }

}
