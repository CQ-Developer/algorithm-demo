package io.huhu.leetcode.dynamic.programming.hard.n664;

class DFS implements Solution {

    @Override
    public int strangePrinter(String s) {
        char[] c = s.toCharArray();
        return dfs(c, 0, c.length - 1);
    }

    private int dfs(char[] s, int l, int r) {
        if (l == r) {
            return 1;
        }
        if (l + 1 == r) {
            return s[l] == s[r] ? 1 : 2;
        }
        if (s[l] == s[r]) {
            return dfs(s, l + 1, r);
        }
        int ans = Integer.MAX_VALUE;
        for (int m = l; m < r; m++) {
            ans = Math.min(ans, dfs(s, l, m) + dfs(s, m + 1, r));
        }
        return ans;
    }

}
