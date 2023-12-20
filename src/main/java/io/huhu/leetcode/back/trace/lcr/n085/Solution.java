package io.huhu.leetcode.back.trace.lcr.n085;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/IDBivT/description/">括号生成</a>
 * <p>正整数n代表生成括号的对数, 请设计一个函数, 用于能够生成所有可能的并且有效的括号组合.
 * <p>提示:
 * <li>1 <= n <= 8
 */
class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTracing(n, n, new StringBuilder(), res);
        return res;
    }

    private void backTracing(int l, int r, StringBuilder sb, List<String> res) {
        if (l == 0 && r == 0) {
            res.add(sb.toString());
            return;
        }
        if (l > 0) {
            sb.append('(');
            backTracing(l - 1, r, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r > 0 && r > l) {
            sb.append(')');
            backTracing(l, r - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
