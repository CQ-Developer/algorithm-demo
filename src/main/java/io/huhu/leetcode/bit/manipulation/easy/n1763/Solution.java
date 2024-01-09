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
     */
    public String longestNiceSubstring(String s) {
        int pos = 0, len = 0, n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int lower = 0, upper = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] >= 'a') {
                    lower |= 1 << (arr[j] - 'a');
                } else {
                    upper |= 1 << (arr[j] - 'A');
                }
                if (lower == upper && j - i + 1 > len) {
                    pos = i;
                    len = j - i + 1;
                }
            }
        }
        return String.valueOf(arr, pos, len);
    }

}
