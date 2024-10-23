package io.huhu.leetcode.n792;

import java.util.Arrays;

class DP implements Code {

    @Override
    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        int[][] dp = new int[n + 1][26];
        Arrays.fill(dp[n], n);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = dp[i + 1][j];
            }
            int j = s.charAt(i) - 'a';
            dp[i][j] = i;
        }
        int ans = 0;
        for (String word : words) {
            if (isSubsequence(n, word, dp)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isSubsequence(int n, String word, int[][] dp) {
        int i = 0, k = 0;
        while (k < word.length()) {
            int j = word.charAt(k) - 'a';
            if (dp[i][j] == n) {
                return false;
            }
            k++;
            i = dp[i][j] + 1;
        }
        return true;
    }

}
