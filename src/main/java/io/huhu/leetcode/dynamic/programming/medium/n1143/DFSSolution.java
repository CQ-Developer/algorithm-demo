package io.huhu.leetcode.dynamic.programming.medium.n1143;

final class DFSSolution extends Solution {

    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        return dfs(c1, c1.length, c2, c2.length);
    }

    private int dfs(char[] s1, int i, char[] s2, int j) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (s1[i - 1] == s2[j - 1]) {
            return dfs(s1, i - 1, s2, j - 1) + 1;
        }
        return Math.max(dfs(s1, i - 1, s2, j), dfs(s1, i, s2, j - 1));
    }

}
