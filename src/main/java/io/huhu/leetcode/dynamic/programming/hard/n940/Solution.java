package io.huhu.leetcode.dynamic.programming.hard.n940;

/**
 * <a href="https://leetcode.cn/problems/distinct-subsequences-ii/description/">
 * Distinct Subsequences II
 * </a>
 */
class Solution {

    public int distinctSubseqII(String s) {
        int[] f = new int[26];
        int sum = 1, mod = 1000000007;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            int old = (sum - f[i]) % mod;
            sum = (sum + old) % mod;
            f[i] = (f[i] + old) % mod;
        }
        return (sum - 1 + mod) % mod;
    }

}
