package io.huhu.leetcode.n494;

import java.util.Arrays;

class DFS implements Code {

    /**
     * 假设所有添加负号的数字的和为 a, 所有添加正号的数字和则为 sum - a,
     * target = (sum - a) - a = sum - 2a,
     * a = (sum - target) / 2,
     * 由于 nums[i] >= 0 所以必然存在 a >= 0,
     * 必然存在 sum - target >= 0 且 sum - target 必然为偶数,
     * 原问题转为01背包问题: 和为 a 的组合个数.
     */
    @Override
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        sum -= target;
        if (sum < 0 || ((sum & 1) == 1)) {
            return 0;
        }
        sum /= 2;
        int n = nums.length;
        int[][] dp = new int[n][sum + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return f(nums, n - 1, sum, dp);
    }

    private int f(int[] nums, int i, int j, int[][] dp) {
        if (i == -1) {
            return j == 0 ? 1 : 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = f(nums, i - 1, j, dp);
        if (j >= nums[i]) {
            ans += f(nums, i - 1, j - nums[i], dp);
        }
        return dp[i][j] = ans;
    }

}
