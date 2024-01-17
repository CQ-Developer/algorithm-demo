package io.huhu.leetcode.dynamic.programming.easy.n392;

/**
 * <a href="https://leetcode.cn/problems/is-subsequence/description/">判断子序列</a>
 */
class Solution {

    public boolean isSubsequence(String s, String t) {
        return dp(s.toCharArray(), 0, t.toCharArray(), 0);
    }

    private boolean dp(char[] s, int i, char[] t, int j) {
        if (i == s.length) {
            return true;
        }
        if (j == t.length) {
            return false;
        }
        if (s[i] == t[j]) {
            return dp(s, i + 1, t, j + 1);
        }
        return dp(s, i, t, j + 1);
    }

}
