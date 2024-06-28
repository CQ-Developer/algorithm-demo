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
abstract class Solution {

    /**
     * <ul>
     * <li>1 <= s.length <= 10<sup>5</sup></li>
     * <li>s consists of lowercase English letters.</li>
     * </ul>
     */
    protected abstract int findSubstringInWraproundString(String s);

}
