package io.huhu.leetcode.back.trace.interview.questions.n08.n08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutation-ii-lcci/description/">有重复字符串的排列组合</a>
 * <p>有重复字符串的排列组合. 编写一种方法, 计算某字符串的所有排列组合.
 * <p>提示:
 * <li>字符都是英文字母
 * <li>字符串长度在[1,9]之间
 */
class Solution {

    public String[] permutation(String S) {
        char[] s = S.toCharArray();
        Arrays.sort(s);
        List<String> res = new ArrayList<>();
        backTracing(s, new boolean[s.length], new char[s.length], 0, res);
        return res.toArray(new String[0]);
    }

    private void backTracing(char[] s, boolean[] used, char[] path, int j, List<String> res) {
        if (j == path.length) {
            res.add(String.valueOf(path));
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && s[i] == s[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path[j] = s[i];
            backTracing(s, used, path, j + 1, res);
            used[i] = false;
        }
    }

}
