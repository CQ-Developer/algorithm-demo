package io.huhu.leetcode.back.trace.n301;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/remove-invalid-parentheses/description/">删除无效的括号</a>
 * <p>给你一个由若干括号和字母组成的字符串s, 删除最小数量的无效括号, 使得输入的字符串有效.
 * <p>返回所有可能的结果. 答案可以按任意顺序返回.
 * <p>提示:
 * <ul>
 * <li>1 <= s.length <= 25
 * <li>s 由小写英文字母以及括号 '(' 和 ')' 组成
 * <li>s 中至多含20个括号
 * </ul>
 */
class Solution {

    private int max = 0;

    public List<String> removeInvalidParentheses(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        while (l < chars.length && chars[l] == ')') {
            l++;
        }
        int r = chars.length - 1;
        while (r > -1 && chars[r] == '(') {
            r--;
        }
        Set<String> res = new HashSet<>();
        backTracing(Arrays.copyOfRange(chars, l, r + 1), 0, 0, 0, new StringBuilder(), res);
        if (res.isEmpty()) {
            res.add("");
        }
        return new ArrayList<>(res);
    }

    private void backTracing(char[] s, int j, int left, int right, StringBuilder sb, Set<String> res) {
        if (j == s.length) {
            if (left == right) {
                max = Math.max(max, sb.length());
                if (sb.length() == max) {
                    res.add(sb.toString());
                }
            }
            return;
        }
        if (s[j] == ')' && left == right) {
            backTracing(s, j + 1, left, right, sb, res);
            return;
        }
        for (int i = j; i < s.length; i++) {
            int l = left, r = right;
            if (s[i] == '(') {
                l++;
            }
            if (s[i] == ')') {
                r++;
            }
            if (r > l) {
                continue;
            }
            sb.append(s[i]);
            backTracing(s, i + 1, l, r, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
