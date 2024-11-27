package io.huhu.leetcode.n1641;

import io.huhu.AC;

@AC
class Memoization implements Code {

    @Override
    public int countVowelStrings(int n) {
        return f(new int[n + 1][5], n, 4);
    }

    private int f(int[][] mem, int i, int j) {
        if (i == 0) {
            return 1;
        }
        if (mem[i][j] != 0) {
            return mem[i][j];
        }
        for (int _j = j; _j >= 0; _j--) {
            mem[i][j] += f(mem, i - 1, _j);
        }
        return mem[i][j];
    }

}
