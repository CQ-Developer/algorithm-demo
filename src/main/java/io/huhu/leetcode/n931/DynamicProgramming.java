package io.huhu.leetcode.n931;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] f = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int ld = 0;
            for (int j = 0; j < n; j++) {
                int _ld = f[j];
                if (j - 1 >= 0) {
                    f[j] = Math.min(f[j], ld);
                }
                if (j + 1 < n) {
                    f[j] = Math.min(f[j], f[j + 1]);
                }
                ld = _ld;
                f[j] += matrix[i][j];
            }
        }
        int ans = f[0];
        for (int j = 1; j < n; j++) {
            ans = Math.min(ans, f[j]);
        }
        return ans;
    }

}
