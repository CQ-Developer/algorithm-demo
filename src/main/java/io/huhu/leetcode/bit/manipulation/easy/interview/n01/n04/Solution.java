package io.huhu.leetcode.bit.manipulation.easy.interview.n01.n04;

/**
 * <a href="https://leetcode.cn/problems/palindrome-permutation-lcci/description/">回文排列</a>
 */
class Solution {

    public boolean canPermutePalindrome(String s) {
        int cnt = 0;
        int[] table = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if ((table[s.charAt(i)]++ & 1) == 1) {
                cnt--;
            } else {
                cnt++;
            }
        }
        return cnt <= 1;
    }

}
