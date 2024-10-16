package io.huhu.leetcode.n583;

class DP implements Code {

    @Override
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int m = w1.length, n = w2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j < n; j++) {
            dp[m][j] = n - j;
        }
        for (int i = 0; i < m; i++) {
            dp[i][n] = m - i;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (w1[i] == w2[j]) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + 1;
                }
            }
        }
        return dp[0][0];
    }

}
