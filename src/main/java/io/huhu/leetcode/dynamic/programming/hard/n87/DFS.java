package io.huhu.leetcode.dynamic.programming.hard.n87;

final class DFS implements Solution {

    @Override
    public boolean isScramble(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int n = c1.length;
        return dfs(c1, 0, n - 1, c2, 0, n - 1);
    }

    private boolean dfs(char[] s1, int l1, int r1, char[] s2, int l2, int r2) {
        if (l1 == r1) {
            return s1[l1] == s2[l2];
        }
        for (int i = l1, j = l2; i < r1; i++, j++) {
            if (dfs(s1, l1, i, s2, l2, j) && dfs(s1, i + 1, r1, s2, j + 1, r2)) {
                return true;
            }
        }
        for (int i = l1, j = r2; i < r1; i++, j--) {
            if (dfs(s1, l1, i, s2, j, r2) && dfs(s1, i + 1, r1, s2, l2, j - 1)) {
                return true;
            }
        }
        return false;
    }

}
