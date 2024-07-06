package io.huhu.leetcode.dynamic.programming.medium.n474;

final class DP implements Solution {

    @Override
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][][] f = new int[l + 1][m + 1][n + 1];
        for (int i = l - 1; i >= 0; i--) {
            int z = 0, o = 0;
            for (int x = 0; x < strs[i].length(); x++) {
                char c = strs[i].charAt(x);
                if (c == '0') {
                    o++;
                }
                if (c == '1') {
                    z++;
                }
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    f[i][j][k] = f[i + 1][j][k];
                    if (j >= o && k >= z && f[i + 1][j - o][k - z] >= f[i][j][k]) {
                        f[i][j][k] = f[i + 1][j - o][k - z] + 1;
                    }
                }
            }
        }
        return f[0][m][n];
    }

}
