package io.huhu.leetcode.n712;

import java.util.Arrays;

class DP implements Code {

    @Override
    public int minimumDeleteSum(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int m = c1.length, n = c2.length;
        int[][] f = new int[m + 1][n + 1];
        f[m][n - 1] = c2[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            f[m][j] = f[m][j + 1] + c2[j];
        }
        f[m - 1][n] = c1[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            f[i][n] = f[i + 1][n] + c1[i];
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (c1[i] == c2[j]) {
                    f[i][j] = f[i + 1][j + 1];
                } else {
                    f[i][j] = Math.min(f[i + 1][j] + c1[i], f[i][j + 1] + c2[j]);
                }
            }
        }
        for (int i = 0; i <= m; i++) {
            System.out.println(Arrays.toString(f[i]));
        }
        return f[0][0];
    }

}
