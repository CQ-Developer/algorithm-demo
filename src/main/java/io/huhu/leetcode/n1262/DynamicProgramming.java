package io.huhu.leetcode.n1262;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] f = new int[2][3];
        f[0][1] = f[0][2] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                f[(i + 1) % 2][j] = Math.max(f[i % 2][j], f[i % 2][(j + nums[i]) % 3] + nums[i]);
            }
        }
        return f[n % 2][0];
    }

}
