package io.huhu.leetcode.n139;

import java.util.List;

class DFS implements Code {

    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        return f(s, 0, wordDict, new int[s.length()]);
    }

    private boolean f(String s, int i, List<String> wordDict, int[] dp) {
        if (i == s.length()) {
            return true;
        }
        if (dp[i] != 0) {
            return dp[i] == 1;
        }
        for (String word : wordDict) {
            if (s.startsWith(word, i) && f(s, i + word.length(), wordDict, dp)) {
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = -1;
        return false;
    }

}
