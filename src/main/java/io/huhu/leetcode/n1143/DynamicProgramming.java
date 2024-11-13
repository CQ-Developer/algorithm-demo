package io.huhu.leetcode.n1143;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray(), c2 = text2.toCharArray();
        int m = c1.length, n = c2.length;
        int[][] f = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (c1[i] == c2[j]) {
                    f[i][j] = f[i + 1][j + 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j + 1]);
                }
            }
        }
        return f[0][0];
    }

}
