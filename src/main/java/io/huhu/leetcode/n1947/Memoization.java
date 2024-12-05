package io.huhu.leetcode.n1947;

import io.huhu.AC;

import java.util.Arrays;

@AC
class Memoization implements Code {

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int n = mentors.length;
        int[][] dp = new int[n][1 << n];
        for (int[] _dp : dp) {
            Arrays.fill(_dp, -1);
        }
        return f(students, mentors, dp, 0, 0);
    }

    private int f(int[][] students, int[][] mentors, int[][] mem, int i, int s) {
        if (i == students.length) {
            return 0;
        }
        if (mem[i][s] != -1) {
            return mem[i][s];
        }
        int res = 0;
        for (int j = 0; j < mentors.length; j++) {
            if (((1 << j) & s) == 0) {
                res = Math.max(res, f(students, mentors, mem, i + 1, s | (1 << j)) + score(students[i], mentors[j]));
            }
        }
        return mem[i][s] = res;
    }

    private int score(int[] stu, int[] men) {
        int s = 0;
        for (int i = 0; i < stu.length; i++) {
            s += stu[i] ^ men[i] ^ 1;
        }
        return s;
    }

}
