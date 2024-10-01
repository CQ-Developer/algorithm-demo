package io.huhu.leetcode.n139;

import java.util.List;

class DP implements Code {

    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (String word : wordDict) {
                int m = word.length();
                if (s.startsWith(word, i) && i + m <= n && dp[i + m]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

}
