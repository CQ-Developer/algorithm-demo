package io.huhu.leetcode.n1937;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[][] f = new long[m][n];
        for (int j = 0; j < n; j++) {
            f[0][j] = points[0][j];
        }
        for (int i = 1; i < m; i++) {
            // k < j
            long max = Long.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, f[i - 1][j] + j);
                f[i][j] = Math.max(f[i][j], points[i][j] - j + max);
            }
            // j <= k
            max = Long.MIN_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                max = Math.max(max, f[i - 1][j] - j);
                f[i][j] = Math.max(f[i][j], points[i][j] + j + max);
            }
        }
        long ans = Long.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, f[m - 1][j]);
        }
        return ans;
    }

}
