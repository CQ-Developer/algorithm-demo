package io.huhu.leetcode.dynamic.programming.medium.n5;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/description/">最长回文子串</a>
 */
class Solution {

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n < 2) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int l = 0, max = 1;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                // len = j - i + 1;
                int j = len + i - 1;
                if (j >= n) {
                    break;
                }
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    // j - i + 1 < 4 表示字符串长度小于4
                    // 简化为 j - i < 3
                    dp[i][j] = j - i < 3 || dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > max) {
                    l = i;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(l, l + max);
    }

}
