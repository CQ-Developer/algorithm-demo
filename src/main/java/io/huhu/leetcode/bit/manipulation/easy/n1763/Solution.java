package io.huhu.leetcode.bit.manipulation.easy.n1763;

/**
 * <a href="https://leetcode.cn/problems/longest-nice-substring/description/">最长的美好子字符串</a>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= s.length <= 100</li>
     * <li>s只包含大写和小写英文字母</li>
     * </ul>
     * <p>分治</p>
     * <p>注意: 'a' ^ 32 = 'A', 可以通过这种方式快速的进行大小写的转换</p>
     */
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            c ^= 32;
            if (!s.contains(String.valueOf(c))) {
                String s1 = longestNiceSubstring(s.substring(0, i));
                String s2 = longestNiceSubstring(s.substring(i + 1));
                return s1.length() >= s2.length() ? s1 : s2;
            }
        }
        return s;
    }

}
