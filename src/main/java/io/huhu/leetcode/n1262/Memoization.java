package io.huhu.leetcode.n1262;

import io.huhu.AC;

import java.util.Arrays;

@AC
class Memoization implements Code {

    @Override
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n][3];
        for (int[] _f : f) {
            Arrays.fill(_f, -1);
        }
        return dfs(nums, f, n - 1, 0);
    }

    private int dfs(int[] nums, int[][] f, int i, int j) {
        if (i == -1) {
            return j == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (f[i][j] != -1) {
            return f[i][j];
        }
        return f[i][j] = Math.max(dfs(nums, f, i - 1, j), dfs(nums, f, i - 1, (j + nums[i]) % 3) + nums[i]);
    }

}
