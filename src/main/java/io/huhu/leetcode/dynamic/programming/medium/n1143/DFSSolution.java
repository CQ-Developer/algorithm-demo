package io.huhu.leetcode.dynamic.programming.medium.n1143;

final class DFSSolution extends Solution {

    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1= text1.toCharArray(), s2 = text2.toCharArray();
        return dfs(s1, s1.length - 1, s2, s2.length - 1);
    }

    private int dfs(char[] s1, int i1, char[] s2, int i2) {
        if (i1 < 0 || i2 < 0) {
            return 0;
        }
        int a = dfs(s1, i1 - 1, s2, i2 - 1);
        int b = s1[i1] == s2[i2] ? a + 1 : 0;
        int c = dfs(s1, i1 - 1, s2, i2);
        int d = dfs(s1, i1, s2, i2 - 1);
        return Math.max(Math.max(a, b), Math.max(c, d));
    }

}
