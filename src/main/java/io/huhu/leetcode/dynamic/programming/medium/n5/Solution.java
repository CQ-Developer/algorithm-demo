package io.huhu.leetcode.dynamic.programming.medium.n5;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/description/">最长回文子串</a>
 */
class Solution {

    public String longestPalindrome(String s) {
        String res = "";
        int max = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        // n - (max >> 1) 表示剩下的字符串长度不可能超过max了，提前结束
        for (int i = 0; i < n - (max >> 1); i++) {
            int l = i - 1, r = i + 1, len = 1;
            while (l >= 0 && chars[l] == chars[i]) {
                l--;
                len++;
            }
            while (r < n && chars[r] == chars[i]) {
                r++;
                len++;
            }
            while (l >= 0 && r < n && chars[l] == chars[r]) {
                l--;
                r++;
                len += 2;
            }
            if (len > max) {
                max = len;
                res = s.substring(l + 1, r);
            }
        }
        return res;
    }

}
