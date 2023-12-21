package io.huhu.leetcode.back.trace.interview.questions.n08.n09;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/bracket-lcci/description/">括号</a>
 * <p>括号. 设计一种算法, 打印n对括号的所有合法的(例如, 开闭一一对应)组合.
 * <p>说明: 解集不能包含重复的子集.
 * <p>例如: 给出n=3, 生成结果为:
 * <pre>
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * </pre>
 */
class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTracing(n, n, new char[2 * n], 0, res);
        return res;
    }

    private void backTracing(int l, int r, char[] path, int i, List<String> res) {
        if (i == path.length) {
            res.add(String.valueOf(path));
            return;
        }
        if (l > 0) {
            path[i] = '(';
            backTracing(l - 1, r, path, i + 1, res);
        }
        if (r > 0 && r > l) {
            path[i] = ')';
            backTracing(l, r - 1, path, i + 1, res);
        }
    }

}
