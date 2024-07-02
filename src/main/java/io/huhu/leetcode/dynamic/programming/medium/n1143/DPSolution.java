package io.huhu.leetcode.dynamic.programming.medium.n1143;

final class DPSolution extends Solution {

    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() > text2.length()) {
            return dp(text1.toCharArray(), text2.toCharArray());
        }
        return dp(text2.toCharArray(), text1.toCharArray());
    }

    private int dp(char[] s1, char[] s2) {
        int n = s1.length, m = s2.length;
        int[] f = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            int leftup = 0;
            for (int j = 1; j <= m; j++) {
                int t = f[j];
                if (s1[i - 1] == s2[j - 1]) {
                    f[j] = 1 + leftup;
                } else {
                    f[j] = Math.max(f[j - 1], f[j]);
                }
                leftup = t;
            }
        }
        return f[m];
    }

}
