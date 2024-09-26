package io.huhu.leetcode.n22;

import java.util.ArrayList;
import java.util.List;

class BackTrace implements Code {

    @Override
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        f(ans, new char[n << 1], 0, n, n);
        return ans;
    }

    private void f(List<String> ans, char[] c, int i, int l, int r) {
        if (l == 0 && r == 0) {
            ans.add(String.valueOf(c));
            return;
        }
        if (l > 0) {
            c[i] = '(';
            f(ans, c, i + 1, l - 1, r);
        }
        if (r > l) {
            c[i] = ')';
            f(ans, c, i + 1, l, r - 1);
        }
    }

}
