package io.huhu.leetcode.n2002;

import io.huhu.AC;

@AC
class BackTracing implements Solution {

    @Override
    public int maxProduct(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        return f(c, 0, new char[n], 0, new char[n], 0);
    }

    private int f(char[] s, int i, char[] s1, int m, char[] s2, int n) {
        // 找到一种情况
        if (i == s.length) {
            return isPalindromic(s1, m) && isPalindromic(s2, n) ? m * n : 0;
        }
        // 不选当前字符
        int res = f(s, i + 1, s1, m, s2, n);
        // s1选择当前字符
        s1[m] = s[i];
        res = Math.max(res, f(s, i + 1, s1, m + 1, s2, n));
        // s2选择当前字符
        s2[n] = s[i];
        return Math.max(res, f(s, i + 1, s1, m, s2, n + 1));
    }

    /**
     * 判断字符串是否是回文
     */
    private boolean isPalindromic(char[] s, int len) {
        int l = 0, r = len - 1;
        while (l < r) {
            if (s[l++] != s[r--]) {
                return false;
            }
        }
        return true;
    }

}
