package io.huhu.leetcode.n1262;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n + 3][3];
        f[0][1] = f[0][2] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 2; j >= 0; j--) {
                f[i + 1][j] = Math.max(f[i][j], f[i][(j + nums[i]) % 3] + nums[i]);
            }
        }
        return f[n][0];
    }

}
