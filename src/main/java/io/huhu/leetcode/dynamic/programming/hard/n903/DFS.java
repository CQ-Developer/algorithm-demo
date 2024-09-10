package io.huhu.leetcode.dynamic.programming.hard.n903;

class DFS implements Solution {

    @Override
    public int numPermsDISequence(String s) {
        char[] c = s.toCharArray();
        return dfs(c, 0, c.length + 1, c.length + 1);
    }

    private int dfs(char[] s, int i, int less, int n) {
        int ans = 0;
        if (i == n) {
            return 1;
        } else if (i == 0 || s[i - 1] == 'D') {
            for (int j = 0; j < less; j++) {
                ans += dfs(s, i + 1, j, n);
            }
        } else {
            for (int j = less; j < n - i; j++) {
                ans += dfs(s, i + 1, j, n);
            }
        }
        return ans;
    }

}
