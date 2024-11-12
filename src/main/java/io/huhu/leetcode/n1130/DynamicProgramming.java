package io.huhu.leetcode.n1130;

class DynamicProgramming implements Code {

    @Override
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] g = new int[n][n], f = new int[n][n];
        for (int l = n - 1; l >= 0; l--) {
            g[l][l] = arr[l];
            for (int r = l + 1; r < n; r++) {
                g[l][r] = Math.max(g[l][r - 1], arr[r]);
                int ans = Integer.MAX_VALUE;
                for (int i = l; i < r; i++) {
                    ans = Math.min(ans, f[l][i] + f[i + 1][r] + g[l][i] * g[i + 1][r]);
                }
                f[l][r] = ans;
            }
        }
        return f[0][n - 1];
    }

}
