package io.huhu.leetcode.dynamic.programming.medium.n241;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/different-ways-to-add-parentheses/description/">为运算表达式设计优先级</a>
 */
class Solution {

    /**
     * <ul>
     * <li>1 &lt;= expression.length &lt;= 20</li>
     * <li>expression由数字和算符'+', '-'和'*'组成</li>
     * <li>输入表达式中的所有整数值在范围[0,99]</li>
     * </ul>
     */
    public List<Integer> diffWaysToCompute(String expression) {
        if (isDigit(expression)) {
            return List.of(Integer.valueOf(expression));
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        int ans = switch (c) {
                            case '+' -> l + r;
                            case '-' -> l - r;
                            case '*' -> l * r;
                            default -> 0;
                        };
                        res.add(ans);
                    }
                }
            }
        }
        return res;
    }

    private boolean isDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

}
