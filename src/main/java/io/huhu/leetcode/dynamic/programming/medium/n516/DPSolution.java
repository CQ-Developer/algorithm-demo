package io.huhu.leetcode.dynamic.programming.medium.n516;

final class DPSolution extends Solution {

    @Override
    public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] f = new int[n];
        for (int i = n - 1, leftDown = 0; i >= 0; i--) {
            f[i] = 1;
            if (i + 1 < n) {
                leftDown = f[i + 1];
                f[i + 1] = c[i] == c[i + 1] ? 2 : 1;
            }
            for (int j = i + 2; j < n; j++) {
                int t = f[j];
                if (c[i] == c[j]) {
                    f[j] = leftDown + 2;
                } else {
                    f[j] = Math.max(f[j], f[j - 1]);
                }
                leftDown = t;
            }
        }
        return f[n - 1];
    }

}
