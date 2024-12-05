package io.huhu.leetcode.n1947;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length, n = 1 << m;
        int[] f = new int[1 << m];
        for (int[] student : students) {
            for (int s = 0; s < n; s++) {
                for (int j = 0; j < m; j++) {
                    if (((1 << j) & s) == 0) {
                        f[s] = Math.max(f[s], f[s | (1 << j)] + score(student, mentors[j]));
                    }
                }
            }
        }
        return f[0];
    }

    private int score(int[] stu, int[] men) {
        int res = 0;
        for (int i = 0; i < stu.length; i++) {
            res += stu[i] ^ men[i] ^ 1;
        }
        return res;
    }

}
