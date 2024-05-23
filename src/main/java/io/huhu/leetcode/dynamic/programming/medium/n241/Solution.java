package io.huhu.leetcode.dynamic.programming.medium.n241;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/different-ways-to-add-parentheses/description/">为运算表达式设计优先级</a>
 */
class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        char[] chars = expression.toCharArray();
        return diffWaysToCompute(chars, 0, chars.length);
    }

    private List<Integer> diffWaysToCompute(char[] expr, int s, int e) {
        if (isDigit(expr, s, e)) {
            return List.of(toDigit(expr, s, e));
        }
        List<Integer> res = new ArrayList<>();
        for (int i = s; i < e; i++) {
            char c = expr[i];
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expr, s, i);
                List<Integer> right = diffWaysToCompute(expr, i + 1, e);
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean isDigit(char[] expr, int s, int e) {
        for (int i = s; i < e; i++) {
            if (expr[i] < '0' || expr[i] > '9') {
                return false;
            }
        }
        return true;
    }

    private int toDigit(char[] expr, int s, int e) {
        int num = 0;
        for (int i = s; i < e; i++) {
            int n = expr[i] - '0';
            num = 10 * num + n;
        }
        return num;
    }

}
