package io.huhu.leetcode.back.trace.n2002;

/**
 * <a href="https://leetcode.cn/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/description/">两个回文子序列长度的最大乘积</a>
 * <p>给你一个字符串s, 请你找到s中两个不相交回文子序列, 使得它们长度的乘积最大.
 * 两个子序列在原字符串中如果没有任何相同下标的字符串, 则它们是互不相交的.
 * <p>请你返回两个回文子序列长度可以达到的最大乘积.
 * <p>子序列指的是从原字符串中删除若干字符后, 剩余字符不改变顺序而得到的结果.
 * 如果一个字符串从前往后读和从后往前读一摸一样, 那么这个字符串是一个回文字符串.
 */
class Solution {

    private int result;

    /**
     * <p>提示:
     * <ul>
     * <li>2 <= s.length <= 12
     * <li>s只含有小写英文字母
     * </ul>
     */
    public int maxProduct(String s) {
        dfs(s.toCharArray(), "", "", 0);
        return result;
    }

    /**
     * 深度优先遍历 + 回溯
     * 核心思想，两个子串都可以选或不选当前字符
     */
    private void dfs(char[] s, String s1, String s2, int i) {
        if (check(s1) && check(s2)) {
            result = Math.max(result, s1.length() * s2.length());
        }
        if (i == s.length) {
            return;
        }
        dfs(s, s1 + s[i], s2, i + 1);
        dfs(s, s1, s2 + s[i], i + 1);
        dfs(s, s1, s2, i + 1);
    }

    private boolean check(CharSequence s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

}
