package io.huhu.leetcode.n376;

class DFS implements Code {

    @Override
    public int wiggleMaxLength(int[] nums) {
        int[][] dp = new int[nums.length][2];
        setupCache(dp);
        int a = f(nums, 1, 0, dp);
        setupCache(dp);
        int b = f(nums, 1, 1, dp);
        return Math.max(a, b) + 1;
    }

    /**
     * f(i,j)表示来到第i个数字且趋势为j的情况下最大的摆动序列的长度
     *
     * @param i 当前处理的数字下标
     * @param j 之前的摆动趋势, 0表示下降趋势, 1表示上升趋势
     */
    private int f(int[] nums, int i, int j, int[][] dp) {
        if (i == nums.length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = f(nums, i + 1, j, dp);
        if (j == 0 && nums[i] > nums[i - 1]) {
            ans = Math.max(ans, f(nums, i + 1, 1, dp) + 1);
        }
        if (j == 1 && nums[i] < nums[i - 1]) {
            ans = Math.max(ans, f(nums, i + 1, 0, dp) + 1);
        }
        return dp[i][j] = ans;
    }

    private void setupCache(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
    }

}
