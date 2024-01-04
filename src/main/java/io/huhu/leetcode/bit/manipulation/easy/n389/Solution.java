package io.huhu.leetcode.bit.manipulation.easy.n389;

/**
 * <a href="https://leetcode.cn/problems/find-the-difference/description/">找不同</a>
 */
class Solution {

    public char findTheDifference(String s, String t) {
        int res = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            res ^= (s.charAt(i) ^ t.charAt(i));
        }
        res ^= t.charAt(n);
        return (char) res;
    }

}
