package io.huhu.leetcode.back.trace.n22;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1><a href="https://leetcode.cn/problems/generate-parentheses/description/">22.括号生成</a></h1>
 * 数字n代表生成括号的对数, 请你设计一个函数,
 * 用于能够生成所有可能的并且有效的括号组合.
 */
class Solution {

    /**
     * 1 <= n <= 8
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrace(new StringBuilder(), n, n, result);
        return result;
    }

    /**
     * 回溯算法
     */
    private void backTrace(StringBuilder sb, int l, int r, List<String> result) {
        if (l == 0 && r == 0) {
            result.add(sb.toString());
            return;
        }
        if (l > 0) {
            backTrace(sb.append("("), l - 1, r, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r > l) {
            backTrace(sb.append(")"), l, r - 1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
