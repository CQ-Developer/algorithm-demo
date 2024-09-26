package io.huhu.leetcode.n22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DP implements Code {

    @Override
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        ans.add("()");
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            while (!ans.isEmpty()) {
                sb.append(ans.removeFirst());
                for (int l = 0; l < sb.length(); l++) {
                    if (sb.charAt(l) != '(') {
                        continue;
                    }
                    int r = l + 1;
                    if (sb.charAt(r) != ')') {
                        continue;
                    }
                    sb.insert(r, "()");
                    set.add(sb.toString());
                    sb.delete(r, r + 2);
                    sb.insert(r + 1, "()");
                    set.add(sb.toString());
                    sb.delete(r + 1, r + 3);
                }
                sb.setLength(0);
            }
            ans.addAll(set);
            set.clear();
        }
        return ans;
    }

}
