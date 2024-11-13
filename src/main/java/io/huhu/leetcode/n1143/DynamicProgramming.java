package io.huhu.leetcode.n1143;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray(), c2 = text2.toCharArray();
        int m = c1.length, n = c2.length;
        int[] f = new int[n + 1];
        for (int i = m - 1; i >= 0; i--) {
            int rightDown = 0;
            for (int j = n - 1; j >= 0; j--) {
                int _rightDown = f[j];
                if (c1[i] == c2[j]) {
                    f[j] = rightDown + 1;
                } else {
                    f[j] = Math.max(f[j], f[j + 1]);
                }
                rightDown = _rightDown;
            }
        }
        return f[0];
    }

}
