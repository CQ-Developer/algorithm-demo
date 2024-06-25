package io.huhu.leetcode.dynamic.programming.medium.n467;

/**
 * <h1>
 * <a href="https://leetcode.cn/problems/unique-substrings-in-wraparound-string/description/">Unique Substring in Wraparound String</a>
 * </h1>
 * <p>
 * We define the string base to be the infinite wraparound string of
 * "abcdefghijklmnopqrstuvwxyz", so base will look like this:
 * </p>
 * <ul>
 * <li>"...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd..."</li>
 * </ul>
 * <p>
 * Given a string s, return the number of unique non-empty substring
 * of s are present in base.
 * </p>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= s.length <= 10<sup>5</sup></li>
     * <li>s consists of lowercase English letters.</li>
     * </ul>
     */
    public int findSubstringInWraproundString(String s) {
        int[] f = new int[26];
        int j = -1, n = 0;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            n = (i == j + 1) || (j == 25 && i == 0) ? n + 1 : 1;
            if (n > f[i]) {
                f[i] = n;
            }
            j = i;
        }
        int sum = 0;
        for (int i : f) {
            sum += i;
        }
        return sum;
    }

}
