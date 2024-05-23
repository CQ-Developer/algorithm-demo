package io.huhu.leetcode.dynamic.programming.medium.n241;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/different-ways-to-add-parentheses/description/">为运算表达式设计优先级</a>
 */
class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        char[] chars = expression.toCharArray();
        return diffWaysToCompute(chars, 0, chars.length - 1);
    }

    private List<Integer> diffWaysToCompute(char[] expr, int s, int e) {
        List<Integer> res = new ArrayList<>();
        int num = 0;
        for (int i = s; i <= e; i++) {
            if (expr[i] == '+' || expr[i] == '-' || expr[i] == '*') {
                List<Integer> left = diffWaysToCompute(expr, s, i - 1);
                List<Integer> right = diffWaysToCompute(expr, i + 1, e);
                for (int l : left) {
                    for (int r : right) {
                        if (expr[i] == '+') {
                            res.add(l + r);
                        } else if (expr[i] == '-') {
                            res.add(l - r);
                        } else {
                            res.add(l * r);
                        }
                    }
                }
            } else {
                num = 10 * num + (expr[i] - '0');
            }
        }
        if (res.isEmpty()) {
            res.add(num);
        }
        return res;
    }

}
