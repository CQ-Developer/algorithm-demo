package io.huhu.leetcode.n474;

class DP implements Code {

    @Override
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[] one = new int[len], zero = new int[len];
        for (int i = 0; i < len; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    zero[i]++;
                } else {
                    one[i]++;
                }
            }
        }
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i + 1][j][k];
                    if (j >= zero[i] && k >= one[i]) {
                        dp[i][j][k] = Math.max(dp[i + 1][j][k], dp[i + 1][j - zero[i]][k - one[i]] + 1);
                    }
                }
            }
        }
        return dp[0][m][n];
    }

}
