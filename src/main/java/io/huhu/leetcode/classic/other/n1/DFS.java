package io.huhu.leetcode.classic.other.n1;

class DFS implements Code {

    @Override
    public int maxSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[][] f = new int[nums.length][sum + 1];
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                f[i][j] = -1;
            }
        }
        return dfs(nums, 0, 0, f);
    }

    private int dfs(int[] nums, int i, int sum, int[][] f) {
        if (i == nums.length) {
            return sum % 7 == 0 ? sum : 0;
        }
        if (f[i][sum] != -1) {
            return f[i][sum];
        }
        int a = dfs(nums, i + 1, sum, f);
        int b = dfs(nums, i + 1, sum + nums[i], f);
        return f[i][sum] = Integer.max(a, b);
    }

}
