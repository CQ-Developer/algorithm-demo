package io.huhu.leetcode.dynamic.programming.medium.n1143;

final class DPSolution extends Solution {

    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()) {
            return longestCommonSubsequence(text2, text1);
        }
        int n = text1.length(), m = text2.length();
        int[] f = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            int leftup = 0;
            for (int j = 1; j <= m; j++) {
                int t = f[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
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
