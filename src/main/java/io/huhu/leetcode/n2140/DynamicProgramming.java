package io.huhu.leetcode.n2140;

class DynamicProgramming implements Solution {

    @Override
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] f = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            f[i] = Math.max(f[Math.min(n, i + questions[i][1] + 1)] + questions[i][0], f[i + 1]);
        }
        return f[0];
    }

}
