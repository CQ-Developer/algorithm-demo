package io.huhu.leetcode.bit.manipulation.easy.n389;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-the-difference/description/">找不同</a>
 */
class Solution {

    /**
     * 入口
     *
     * @param s 0 <= s.length <= 1000, 只包含小写字母
     * @param t t.length == s.length + 1, 只包含小写字母
     */
    public char findTheDifference(String s, String t) {
        if (s.isEmpty()) {
            return t.charAt(0);
        }
        char[] a = s.toCharArray();
        Arrays.sort(a);
        char[] b = t.toCharArray();
        Arrays.sort(b);
        for (int i = 0; i < s.length(); i++) {
            if (a[i] != b[i]) {
                return b[i];
            }
        }
        return b[b.length - 1];
    }

}
