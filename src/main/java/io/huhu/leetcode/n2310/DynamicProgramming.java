package io.huhu.leetcode.n2310;

import io.huhu.AC;

@AC
class DynamicProgramming implements Solution {

    @Override
    public int minimumNumbers(int num, int k) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = k; j <= i; j += 10) {
                if (f[i - j] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i], f[i - j] + 1);
                }
            }
        }
        return f[num] == Integer.MAX_VALUE ? -1 : f[num];
    }

}
