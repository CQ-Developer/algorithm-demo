package io.huhu.leetcode.n583;

class DP implements Code {

    @Override
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int m = w1.length, n = w2.length;
        int[] dp = new int[n + 1];
        for (int j = 0; j < n; j++) {
            dp[j] = n - j;
        }
        for (int i = m - 1; i >= 0; i--) {
            int rd = dp[n];
            dp[n] = m - i;
            for (int j = n - 1; j >= 0; j--) {
                int _rd = dp[j];
                if (w1[i] == w2[j]) {
                    dp[j] = rd;
                } else {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + 1;
                }
                rd = _rd;
            }
        }
        return dp[0];
    }

}
