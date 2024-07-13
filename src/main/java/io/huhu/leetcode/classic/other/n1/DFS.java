package io.huhu.leetcode.classic.other.n1;

class DFS implements Code {

    @Override
    public int maxSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int i, int sum) {
        if (i == nums.length) {
            return sum % 7 == 0 ? sum : 0;
        }
        int a = dfs(nums, i + 1, sum);
        int b = dfs(nums, i + 1, sum + nums[0]);
        return Integer.max(a, b);
    }

}
