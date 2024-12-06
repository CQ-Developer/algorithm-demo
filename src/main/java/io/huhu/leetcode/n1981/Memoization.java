package io.huhu.leetcode.n1981;

import io.huhu.AC;

import java.util.Arrays;

@AC
class Memoization implements Solution {

    @Override
    public int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length, n = 0;
        for (int[] a : mat) {
            int max = 0;
            for (int b : a) {
                max = Math.max(max, b);
            }
            n += max;
        }
        int[][] mem = new int[m][n + 1];
        for (int[] a : mem) {
            Arrays.fill(a, -1);
        }
        return f(mat, target, mem, 0, 0);
    }

    private int f(int[][] mat, int target, int[][] mem, int i, int sum) {
        if (i == mat.length) {
            return Math.abs(sum - target);
        }
        if (mem[i][sum] != -1) {
            return mem[i][sum];
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < mat[0].length; j++) {
            res = Math.min(res, f(mat, target, mem, i + 1, sum + mat[i][j]));
        }
        return mem[i][sum] = res;
    }

}
