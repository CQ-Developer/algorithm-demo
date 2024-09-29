package io.huhu.leetcode.n72;

class DP2 implements Code {

    @Override
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int m = w1.length, n = w2.length;
        int[] dp = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            dp[j] = j;
        }
        for (int i = 1; i <= m; i++) {
            int leftup = i - 1;
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                int backup = dp[j];
                if (w1[i - 1] == w2[j - 1]) {
                    dp[j] = leftup;
                } else {
                    dp[j] = Math.min(leftup, Math.min(dp[j], dp[j - 1])) + 1;
                }
                leftup = backup;
            }
        }
        return dp[n];
    }

}
