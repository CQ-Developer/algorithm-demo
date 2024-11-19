package io.huhu.leetcode.n1262;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int maxSumDivThree(int[] nums) {
        int[] f = new int[3], g = new int[3];
        f[1] = f[2] = Integer.MIN_VALUE;
        for (int num : nums) {
            for (int i = 0; i < 3; i++) {
                g[i] = Math.max(f[i], f[(i + num) % 3] + num);
            }
            for (int i = 0; i < 3; i++) {
                f[i] = g[i];
            }
        }
        return f[0];
    }

}
