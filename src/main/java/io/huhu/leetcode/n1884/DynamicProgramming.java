package io.huhu.leetcode.n1884;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int twoEggDrop(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                ans = Math.min(ans, Math.max(j, f[i - j] + 1));
            }
            f[i] = ans;
        }
        return f[n];
    }

}
