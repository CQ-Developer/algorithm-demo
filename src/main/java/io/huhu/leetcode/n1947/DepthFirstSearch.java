package io.huhu.leetcode.n1947;

import io.huhu.AC;

@AC
class DepthFirstSearch implements Code {

    @Override
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        return f(students, mentors, 0, 0);
    }

    private int f(int[][] stu, int[][] men, int i, int s) {
        if (i == stu.length) {
            return 0;
        }
        int res = 0;
        for (int j = 0; j < men.length; j++) {
            if (((1 << j) & s) == 0) {
                res = Math.max(res, f(stu, men, i + 1, s | (1 << j)) + score(stu[i], men[j]));
            }
        }
        return res;
    }

    private int score(int[] stu, int[] men) {
        int s = 0;
        for (int i = 0; i < stu.length; i++) {
            s += stu[i] ^ men[i] ^ 1;
        }
        return s;
    }

}
