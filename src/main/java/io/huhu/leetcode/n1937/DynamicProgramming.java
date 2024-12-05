package io.huhu.leetcode.n1937;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[] f = new long[n], p = new long[n];
        for (int j = 0; j < n; j++) {
            p[j] = points[0][j];
        }
        for (int i = 1; i < m; i++) {
            // k < j
            long max = Long.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, p[j] + j);
                f[j] = Math.max(f[j], points[i][j] - j + max);
            }
            // j <= k
            max = Long.MIN_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                max = Math.max(max, p[j] - j);
                f[j] = Math.max(f[j], points[i][j] + j + max);
            }
            // exchange
            for (int j = 0; j < n; j++) {
                p[j] = f[j];
            }
        }
        long ans = Long.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, p[j]);
        }
        return ans;
    }

}
