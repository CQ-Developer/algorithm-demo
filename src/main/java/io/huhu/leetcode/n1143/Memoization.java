package io.huhu.leetcode.n1143;

import io.huhu.AC;

import java.util.Arrays;

@AC
class Memoization implements Code {

    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray(), c2 = text2.toCharArray();
        int m = c1.length, n = c2.length;
        int[][] mem = new int[m][n];
        for (int[] _mem : mem) {
            Arrays.fill(_mem, -1);
        }
        return f(c1, c2, mem, 0, 0);
    }

    private int f(char[] c1, char[] c2, int[][] mem, int i, int j) {
        if (i == c1.length || j == c2.length) {
            return 0;
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        if (c1[i] == c2[j]) {
            return mem[i][j] = f(c1, c2, mem, i + 1, j + 1) + 1;
        }
        return mem[i][j] = Math.max(f(c1, c2, mem, i + 1, j), f(c1, c2, mem, i, j + 1));
    }

}
