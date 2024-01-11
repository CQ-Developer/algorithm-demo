package io.huhu.leetcode.bit.manipulation.easy.interview.n01.n04;

/**
 * <a href="https://leetcode.cn/problems/palindrome-permutation-lcci/description/">回文排列</a>
 */
class Solution {

    public boolean canPermutePalindrome(String s) {
        long l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 64) {
                r ^= 1L << s.charAt(i) - 64;
            } else {
                l ^= 1L << s.charAt(i);
            }
        }
        return Long.bitCount(l) + Long.bitCount(r) <= 1;
    }

}
