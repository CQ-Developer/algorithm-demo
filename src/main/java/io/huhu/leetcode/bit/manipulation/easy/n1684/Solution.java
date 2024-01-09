package io.huhu.leetcode.bit.manipulation.easy.n1684;

/**
 * <a href="https://leetcode.cn/problems/count-the-number-of-consistent-strings/description/">统计一致字符的数目</a>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= words.length <= 10<sup>4</sup></li>
     * <li>1 <= allowed.length <= 26</li>
     * <li>1 <= words[i].length <= 10</li>
     * <li>allowed中的字符互不相同</li>
     * <li>words[i]和allowed只包含小写英文字母</li>
     * </ul>
     */
    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;
        for (int i = 0; i < allowed.length(); i++) {
            mask |= 1 << (allowed.charAt(i) - 'a');
        }
        int res = 0;
        for (String word : words) {
            int tmp = 0;
            for (int i = 0; i < word.length(); i++) {
                tmp |= 1 << (word.charAt(i) - 'a');
            }
            if ((mask | tmp) == mask) {
                res++;
            }
        }
        return res;
    }

}
