package io.huhu.leetcode.dynamic.programming.medium.n300;

class DFS implements Solution {

    @Override
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans = Integer.max(ans, dfs(nums, i, f));
        }
        return ans;
    }

    private int dfs(int[] nums, int i, int[] f) {
        if (f[i] != 0) {
            return f[i];
        }
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                f[i] = Integer.max(f[i], dfs(nums, j, f));
            }
        }
        return ++f[i];
    }

}
