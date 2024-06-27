package io.huhu.leetcode.dynamic.programming.medium.n639;

/**
 * <a href="https://leetcode.cn/problems/decode-ways-ii/description/">Decode Ways II</a>
 */
abstract sealed class Solution permits DFSSolution, DPSolution {

    /**
     * <ul>
     * <li>1 <= s.length <= 10<sup>5</sup></li>
     * <li>s[i] is a digit or '*'</li>
     * </ul>
     */
    protected abstract int numDecodings(String s);

}
