package io.huhu.leetcode.dynamic.programming.hard.n903;

/**
 * States Compression DP
 */
class SCDP implements Solution {

    private static final int M = 1000000007;

    @Override
    public int numPermsDISequence(String s) {
        char[] c = s.toCharArray();
        int n = c.length + 1;
        int[] down = new int[n + 1], up = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            down[i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == 0 || c[i - 1] == 'D') {
                up[1] = down[0];
                for (int j = 2; j <= n; j++) {
                    up[j] = (up[j - 1] + down[j - 1]) % M;
                }
            } else {
                up[n - i - 1] = down[n - i - 1];
                for (int j = n - i - 2; j >= 0; j--) {
                    up[j] = (up[j + 1] + down[j]) % M;
                }
            }
            for (int j = 0; j <= n; j++) {
                down[j] = up[j];
                up[j] = 0;
            }
        }
        return down[n];
    }

}
