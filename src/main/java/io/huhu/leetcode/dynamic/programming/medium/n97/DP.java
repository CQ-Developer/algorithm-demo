package io.huhu.leetcode.dynamic.programming.medium.n97;

final class DP implements Solution {

    @Override
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int m = c1.length, n = c2.length;
        if (m + n != c3.length) {
            return false;
        }
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (c1[i - 1] != c3[i - 1]) {
                break;
            }
            f[i][0] = true;
        }
        for (int j = 1; j <= n; j++) {
            if (c2[j - 1] != c3[j - 1]) {
                break;
            }
            f[0][j] = true;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = (c1[i - 1] == c3[i + j - 1] && f[i - 1][j]) || (c2[j - 1] == c3[i + j - 1] && f[i][j - 1]);
            }
        }
        return f[m][n];
    }

}
