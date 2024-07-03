package io.huhu.leetcode.dynamic.programming.medium.n516;

final class DPSolution extends Solution {

    @Override
    public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            if (i + 1 < n) {
                f[i][i + 1] = c[i] == c[i + 1] ? 2 : 1;
            }
            for (int j = i + 2; j < n; j++) {
                if (c[i] == c[j]) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }

}
