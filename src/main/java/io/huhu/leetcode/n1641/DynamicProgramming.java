package io.huhu.leetcode.n1641;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int countVowelStrings(int n) {
        int[] f = {1, 1, 1, 1, 1};
        for (int i = 1; i <= n; i++) {
            for (int j = 4; j >= 0; j--) {
                for (int _j = j - 1; _j >= 0; _j--) {
                    f[j] += f[_j];
                }
            }
        }
        return f[4];
    }

}
