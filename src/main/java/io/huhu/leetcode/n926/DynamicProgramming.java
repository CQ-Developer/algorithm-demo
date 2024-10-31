package io.huhu.leetcode.n926;

/**
 * MLE
 */
class DynamicProgramming implements Code {

    @Override
    public int minFlipsMonoIncr(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] f = new int[n][n];
        for (int l = n - 2; l >= 0; l--) {
            f[l][l + 1] = c[l] <= c[l + 1] ? 0 : 1;
            for (int r = l + 2; r < n; r++) {
                if (c[l] == c[r]) {
                    f[l][r] = Math.min(f[l + 1][r - 1] + 1, c[l] == '0' ? f[l + 1][r] : f[l][r - 1]);
                } else {
                    f[l][r] = c[l] == '0' ? f[l + 1][r - 1] : Math.min(f[l + 1][r] + 1, f[l][r - 1] + 1);
                }
            }
        }
        return f[0][n - 1];
    }

}
