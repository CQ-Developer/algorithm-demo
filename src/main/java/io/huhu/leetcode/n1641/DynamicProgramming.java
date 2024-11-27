package io.huhu.leetcode.n1641;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int countVowelStrings(int n) {
        int[][] f = new int[n + 1][5];
        for (int j = 0; j < 5; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int _j = j; _j >= 0; _j--) {
                    f[i][j] += f[i - 1][_j];
                }
            }
        }
        return f[n][4];
    }

}
