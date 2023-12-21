package io.huhu.leetcode.back.trace.interview.questions.n08.n07;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutation-i-lcci/description/">无重复字符串的排列组合</a>
 * <p>无重复字符串的排列组合. 编写一种方法, 计算某字符串的所有排列组合, 字符串每个字符均不相同.
 * <p>提示:
 * <li>字符都是英文字母
 * <li>字符串长度在[1,9]之间
 */
class Solution {

    public String[] permutation(String S) {
        List<String> res = new ArrayList<>();
        int n = S.length();
        backTracing(S, new boolean[n], n, new char[n], 0, res);
        return res.toArray(new String[0]);
    }

    private void backTracing(String S, boolean[] used, int n, char[] path, int j, List<String> res) {
        if (j == n) {
            res.add(String.valueOf(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path[j] = S.charAt(i);
            backTracing(S, used, n, path, j + 1, res);
            used[i] = false;
        }
    }

}
