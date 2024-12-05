package io.huhu.leetcode.n1947;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length, n = 1 << m;
        int[][] f = new int[m + 1][1 << m];
        for (int i = m - 1; i >= 0; i--) {
            for (int s = n - 1; s >= 0; s--) {
                for (int j = 0; j < m; j++) {
                    if (((1 << j) & s) == 0) {
                        f[i][s] = Math.max(f[i][s], f[i + 1][s | (1 << j)] + score(students[i], mentors[j]));
                    }
                }
            }
        }
        return f[0][0];
    }

    private int score(int[] stu, int[] men) {
        int res = 0;
        for (int i = 0; i < stu.length; i++) {
            res += stu[i] ^ men[i] ^ 1;
        }
        return res;
    }

}
