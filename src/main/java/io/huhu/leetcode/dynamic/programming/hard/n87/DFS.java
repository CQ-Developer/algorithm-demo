package io.huhu.leetcode.dynamic.programming.hard.n87;

final class DFS implements Solution {

    @Override
    public boolean isScramble(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int n = c1.length;
        return f(c1, 0, c2, 0, n);
    }

    private boolean f(char[] s1, int l1, char[] s2, int l2, int n) {
        if (n == 1) {
            return s1[l1] == s2[l2];
        }
        for (int k = 1; k < n; k++) {
            if (f(s1, l1, s2, l2, k) && f(s1, l1 + k, s2, l2 + k, n - k)) {
                return true;
            }
        }
        for (int k = 1, i = l1 + 1, j = l2 + n - 1; k < n; k++, i++, j--) {
            if (f(s1, l1, s2, j, k) && f(s1, i, s2, l2, n - k)) {
                return true;
            }
        }
        return false;
    }

}
