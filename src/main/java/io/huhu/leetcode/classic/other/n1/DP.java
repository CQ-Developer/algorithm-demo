package io.huhu.leetcode.classic.other.n1;

class DP implements Code {

    @Override
    public int maxSum(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n + 1][7];
        for (int j = 1; j < 7; j++) {
            f[0][j] = -1;
        }
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            // 当前需要的余数
            int cur = num % 7;
            for (int j = 0; j < 7; j++) {
                int k = (7 + j - cur) % 7;
                if (f[i - 1][k] != -1) {
                    f[i][j] = Integer.max(f[i - 1][j], f[i - 1][k] + num);
                }
            }
        }
        return f[n][0];
    }

}
