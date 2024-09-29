package io.huhu.leetcode.n91;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        int[] dp = new int[c.length];
        Arrays.fill(dp, -1);
        return f(c, 0, dp);
    }

    private int f(char[] s, int i, int[] dp) {
        if (i == s.length) {
            return 1;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans = 0;
        if (s[i] != '0') {
            ans += f(s, i + 1, dp);
            if (i + 1 < s.length && ((s[i] - '0') * 10 + (s[i + 1] - '0')) <= 26) {
                ans += f(s, i + 2, dp);
            }
        }
        return dp[i] = ans;
    }

}
