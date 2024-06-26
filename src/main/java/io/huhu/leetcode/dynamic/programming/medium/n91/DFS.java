package io.huhu.leetcode.dynamic.programming.medium.n91;

import java.util.Arrays;

class DFS extends Solution {

    @Override
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        Arrays.fill(dp, -1);
        return dfs(chars, 0, dp);
    }

    public int dfs(char[] s, int i, int[] f) {
        if (i == s.length) {
            return 1;
        }
        if (s[i] == '0') {
            return 0;
        }
        if (f[i] != -1) {
            return f[i];
        }
        int ans = dfs(s, i + 1, f);
        if (i + 1 < s.length && ((s[i] - '0') * 10 + (s[i + 1] - '0')) <= 26) {
            ans += dfs(s, i + 2, f);
        }
        return f[i] = ans;
    }

}
