package io.huhu.leetcode.dynamic.programming.hard.n87;

final class DP implements Solution {

    @Override
    public boolean isScramble(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int m = c1.length;
        boolean[][][] f = new boolean[m][m][m + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                f[i][j][1] = c1[i] == c2[j];
            }
        }
        for (int n = 2; n <= m; n++) {
            for (int i = 0; i <= m - n; i++) {
                for (int j = 0; j <= m - n; j++) {
                    for (int k = 1; k < n && !f[i][j][n]; k++) {
                        f[i][j][n] = (f[i][j][k] && f[i + k][j + k][n - k]) || (f[i][j + n - k][k] && f[i + k][j][n - k]);
                    }
                }
            }
        }
        return f[0][0][m];
    }

}
