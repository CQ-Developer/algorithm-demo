package io.huhu.leetcode.bit.manipulation.easy.interview.n01.n01;

/**
 * <a href="https://leetcode.cn/problems/is-unique-lcci/description/">判断字符是否唯一</a>
 */
class Solution {

    public boolean isUnique(String astr) {
        int[] a = new int[26];
        for (int i = 0; i < astr.length(); i++) {
            int j = astr.charAt(i) - 'a';
            a[j]++;
        }
        for (int cnt : a) {
            if (cnt > 1) {
                return false;
            }
        }
        return true;
    }

}
