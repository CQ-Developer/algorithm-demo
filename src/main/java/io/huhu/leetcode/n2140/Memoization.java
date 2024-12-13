package io.huhu.leetcode.n2140;

import io.huhu.AC;

import java.util.Arrays;

@AC
class Memoization implements Solution {

    @Override
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] mem = new long[n];
        Arrays.fill(mem, -1);
        return f(questions, 0, mem);
    }

    private long f(int[][] questions, int i, long[] mem) {
        if (i >= questions.length) {
            return 0;
        }
        if (mem[i] != -1) {
            return mem[i];
        }
        long res = f(questions, i + questions[i][1] + 1, mem) + questions[i][0];
        res = Math.max(res, f(questions, i + 1, mem));
        return mem[i] = res;
    }

}
