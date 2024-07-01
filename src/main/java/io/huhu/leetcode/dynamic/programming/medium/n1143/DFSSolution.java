package io.huhu.leetcode.dynamic.programming.medium.n1143;

final class DFSSolution extends Solution {

    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray(), s2 = text2.toCharArray();
        return dfs(s1, s1.length, s2, s2.length);
    }

    private int dfs(char[] s1, int len1, char[] s2, int len2) {
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        if (s1[len1 - 1] == s2[len2 - 1]) {
            return dfs(s1, len1 - 1, s2, len2 - 1) + 1;
        }
        return Math.max(dfs(s1, len1 - 1, s2, len2), dfs(s1, len1, s2, len2 - 1));
    }

}
