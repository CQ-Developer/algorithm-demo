package io.huhu.leetcode.bit.manipulation.easy.interview.n01.n04;

/**
 * <a href="https://leetcode.cn/problems/palindrome-permutation-lcci/description/">回文排列</a>
 */
class Solution {

    public boolean canPermutePalindrome(String s) {
        int[] table = new int[128];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i)] ^= 1;
        }
        int sum = 0;
        for (int n : table) {
            sum += n;
        }
        return sum <= 1;
    }

}
