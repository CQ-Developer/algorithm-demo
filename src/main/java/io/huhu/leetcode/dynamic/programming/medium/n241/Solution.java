package io.huhu.leetcode.dynamic.programming.medium.n241;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/different-ways-to-add-parentheses/description/">为运算表达式设计优先级</a>
 */
class Solution {

    @SuppressWarnings("unchecked")
    public List<Integer> diffWaysToCompute(String expression) {
        char[] chars = expression.toCharArray();
        int n = chars.length;
        return diffWaysToCompute(chars, 0, n - 1, new ArrayList[n][n]);
    }

    private List<Integer> diffWaysToCompute(char[] expr, int s, int e, List<Integer>[][] cache) {
        if (cache[s][e] != null) {
            return cache[s][e];
        }
        List<Integer> res = new ArrayList<>();
        int num = 0;
        for (int i = s; i <= e; i++) {
            if (expr[i] == '+' || expr[i] == '-' || expr[i] == '*') {
                List<Integer> left = diffWaysToCompute(expr, s, i - 1, cache);
                List<Integer> right = diffWaysToCompute(expr, i + 1, e, cache);
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
        return cache[s][e] = res;
    }

}
