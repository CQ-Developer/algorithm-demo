package io.huhu.leetcode.back.trace.interview.questions.n08.n07;

/**
 * <a href="https://leetcode.cn/problems/permutation-i-lcci/description/">无重复字符串的排列组合</a>
 * <p>无重复字符串的排列组合. 编写一种方法, 计算某字符串的所有排列组合, 字符串每个字符均不相同.
 * <p>提示:
 * <li>字符都是英文字母
 * <li>字符串长度在[1,9]之间
 */
class Solution {

    private int k;
    private String[] res;

    public String[] permutation(String S) {
        setup(S.length());
        backTracing(S.toCharArray(), 0);
        return res;
    }

    private void backTracing(char[] s, int i) {
        if (i == s.length) {
            res[k++] = String.valueOf(s);
            return;
        }
        for (int j = i; j < s.length; j++) {
            swap(s, i, j);
            backTracing(s, i + 1);
            swap(s, j, i);
        }
    }

    private void swap(char[] s, int i, int j) {
        if (i == j) {
            return;
        }
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
    }

    private void setup(int n) {
        int len = 1;
        while (n > 1) {
            len *= n--;
        }
        res = new String[len];
    }

}
