package io.huhu.leetcode.n241;

import java.util.ArrayList;
import java.util.List;

class DP implements Code {

    @Override
    public List<Integer> diffWaysToCompute(String expression) {
        char[] c = expression.toCharArray();
        int n = c.length;
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> sub = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                sub.add(new ArrayList<>());
            }
            dp.add(sub);
        }
        for (int l = n - 1; l >= 0; l--) {
            for (int r = l; r < n; r++) {
                List<Integer> ans = new ArrayList<>();
                int num = 0;
                for (int i = l; i <= r; i++) {
                    if (c[i] == '+' || c[i] == '-' || c[i] == '*') {
                        for (int left : dp.get(l).get(i - 1)) {
                            for (int right : dp.get(i + 1).get(r)) {
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
                dp.get(l).get(r).clear();
                dp.get(l).get(r).addAll(ans);
            }
        }
        return dp.get(0).get(n - 1);
    }

}
