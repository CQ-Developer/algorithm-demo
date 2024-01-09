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
     *
     * <p>一种利用分治思想的更加优秀的解</p>
     * <pre>{@code
     * public String longestNiceSubstring(String s) {
     *     if (s.length() < 2) {
     *         return "";
     *     }
     *     for (int i = 0; i < s.length(); i++) {
     *         char c = s.charAt(i);
     *         if ((Character.isUpperCase(c) && !s.contains(String.valueOf(Character.toLowerCase(c))))
     *          || (Character.isLowerCase(c) && !s.contains(String.valueOf(Character.toUpperCase(c))))) {
     *             String s1 = longestNiceSubstring(s.substring(0, i));
     *             String s2 = longestNiceSubstring(s.substring(i + 1));
     *             return s1.length() >= s2.length() ? s1 : s2;
     *         }
     *     }
     *     return s;
     * }
     * }</pre>
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
