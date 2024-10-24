package io.huhu.leetcode.n813;

class DepthFirstSearch implements Code {

    @Override
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        // 前缀和
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        return f(pre, n - 1, k, new double[n][k + 1]);
    }

    /**
     * f(i,j): 在nums[0...i]范围上将数组分成j份的最大得分
     */
    private double f(int[] p, int i, int j, double[][] m) {
        if (i == -1) {
            return 0;
        }
        if (j == 1) {
            return 1.0 * p[i + 1] / (i + 1);
        }
        for (int _i = 0; _i <= i; _i++) {
            m[i][j] = Math.max(m[i][j], 1.0 * (p[i + 1] - p[_i]) / (i - _i + 1) + f(p, _i - 1, j - 1, m));
        }
        return m[i][j];
    }

}
