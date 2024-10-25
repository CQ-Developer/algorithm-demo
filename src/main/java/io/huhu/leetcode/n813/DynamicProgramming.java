package io.huhu.leetcode.n813;

class DynamicProgramming implements Code {

    @Override
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        int[] p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + nums[i];
        }
        double[][] f = new double[n][k + 1];
        for (int i = 0; i < n; i++) {
            f[i][1] = 1.0 * p[i + 1] / (i + 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int _i = 0; _i <= i; _i++) {
                    if (_i - 1 == -1) {
                        f[i][j] = 0;
                    } else {
                        f[i][j] = Math.max(f[i][j], 1.0 * (p[i + 1] - p[_i]) / (i - _i + 1) + f[_i - 1][j - 1]);
                    }
                }
            }
        }
        return f[n - 1][k];
    }

}
