package io.huhu.leetcode.bit.manipulation.easy.interview.n01.n01;

/**
 * <a href="https://leetcode.cn/problems/is-unique-lcci/description/">判断字符是否唯一</a>
 */
class Solution {

    public boolean isUnique(String astr) {
        int mask = 0;
        for (int i = 0; i < astr.length(); i++) {
            int bit = 1 << (astr.charAt(i) - 'a');
            if ((mask & bit) == bit) {
                return false;
            }
            mask |= bit;
        }
        return true;
    }

}
