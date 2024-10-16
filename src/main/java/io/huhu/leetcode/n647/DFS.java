package io.huhu.leetcode.n647;

class DFS implements Code {

    @Override
    public int countSubstrings(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ans += f(c, i, j);
            }
        }
        return ans;
    }

    private int f(char[] c, int l, int r) {
        if (l == r) {
            return 1;
        }
        if (l + 1 == r) {
            return c[l] == c[r] ? 1 : 0;
        }
        int ans = 0;
        if (c[l] == c[r]) {
            return f(c, l + 1, r - 1);
        }
        return ans;
    }

}
