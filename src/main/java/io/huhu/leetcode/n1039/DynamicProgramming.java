package io.huhu.leetcode.n1039;

class DynamicProgramming implements Code {

    @Override
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] f = new int[n][n];
        for (int l = n - 3; l >= 0; l--) {
            for (int r = l + 2; r < n; r++) {
                int ans = Integer.MAX_VALUE;
                for (int m = l + 1; m < r; m++) {
                    ans = Math.min(ans, f[l][m] + f[m][r] + values[l] * values[m] * values[r]);
                }
                f[l][r] = ans;
            }
        }
        return f[0][n - 1];
    }

}
