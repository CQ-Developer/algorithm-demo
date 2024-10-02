package io.huhu.leetcode.n241;

import java.util.ArrayList;
import java.util.List;

class DaC implements Code {

    @Override
    public List<Integer> diffWaysToCompute(String expression) {
        char[] c = expression.toCharArray();
        int n = c.length;
        return f(c, 0, n - 1);
    }

    private List<Integer> f(char[] c, int l, int r) {
        List<Integer> ans = new ArrayList<>();
        int num = 0;
        for (int i = l; i <= r; i++) {
            if (c[i] == '+' || c[i] == '-' || c[i] == '*') {
                var subL = f(c, l, i - 1);
                var subR = f(c, i + 1, r);
                for (int left : subL) {
                    for (int right : subR) {
                        int res = switch (c[i]) {
                            case '+' -> left + right;
                            case '-' -> left - right;
                            default  -> left * right;
                        };
                        ans.add(res);
                    }
                }
            } else {
                num = 10 * num + (c[i] - '0');
            }
        }
        if (ans.isEmpty()) {
            ans.add(num);
        }
        return ans;
    }

}
