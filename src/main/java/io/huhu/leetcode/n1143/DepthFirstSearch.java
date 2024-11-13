package io.huhu.leetcode.n1143;

import io.huhu.TLE;

@TLE
class DepthFirstSearch implements Code {

    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray(), c2 = text2.toCharArray();
        return f(c1, c2, 0, 0);
    }

    private int f(char[] c1, char[] c2, int i, int j) {
        if (i == c1.length || j == c2.length) {
            return 0;
        }
        if (c1[i] == c2[j]) {
            return f(c1, c2, i + 1, j + 1) + 1;
        }
        return Math.max(f(c1, c2, i + 1, j), f(c1, c2, i, j + 1));
    }

}
