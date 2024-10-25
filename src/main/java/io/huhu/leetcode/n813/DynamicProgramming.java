package io.huhu.leetcode.n813;

class DynamicProgramming implements Code {

    @Override
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        int[] p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + nums[i];
        }
        double[][] f = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            f[i][1] = 1.0 * p[i] / i;
            for (int j = 2; j <= k; j++) {
                for (int _i = 1; _i <= i; _i++) {
                    f[i][j] = Math.max(f[i][j], 1.0 * (p[i] - p[_i - 1]) / (i - _i + 1) + f[_i - 1][j - 1]);
                }
            }
        }
        return f[n][k];
    }

}
