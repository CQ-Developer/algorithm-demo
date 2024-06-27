package io.huhu.leetcode.dynamic.programming.medium.n639;

import java.util.Arrays;

final class DFSSolution extends Solution {

    @Override
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        long[] f = new long[chars.length];
        Arrays.fill(f, -1);
        return (int) dfs(chars, 0, f);
    }

    private long dfs(char[] s, int i, long[] f) {
        if (i == s.length) {
            return 1;
        }
        if (s[i] == '0') {
            return f[i] = 0;
        }
        if (f[i] != -1) {
            return f[i];
        }
        long ans = dfs(s, i + 1, f) * (s[i] == '*' ? 9 : 1);
        if (i + 1 < s.length) {
            if (s[i] == '*') {
                if (s[i + 1] == '*') {
                    ans += dfs(s, i + 2, f) * 15;
                } else {
                    ans += dfs(s, i + 2, f) * (s[i + 1] <= '6' ? 2 : 1);
                }
            } else {
                if (s[i + 1] == '*') {
                    ans += dfs(s, i + 2, f) * (s[i] == '1' ? 9 : s[i] == '2' ? 6 : 0);
                } else {
                    ans += dfs(s, i + 2, f) * ((s[i] - '0') * 10 + (s[i + 1] - '0') <= 26 ? 1 : 0);
                }
            }
        }
        return f[i] = ans % 1000000007;
    }

}
