package io.huhu.leetcode.n1824;

import io.huhu.AC;

import java.util.Arrays;

@AC
class Memoization implements Code {

    @Override
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] mem = new int[n][3];
        for (int[] m : mem) {
            Arrays.fill(m, -1);
        }
        return f(obstacles, mem, 0, 1);
    }

    private int f(int[] obstacles, int[][] mem, int i, int j) {
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        int ans;
        if (i == obstacles.length - 1) {
            ans = 0;
        } else {
            if (obstacles[i + 1] != j + 1) {
                ans = f(obstacles, mem, i + 1, j);
            } else {
                int a = (j + 1) % 3, b = (j + 2) % 3;
                if (obstacles[i] == 0) {
                    ans = Math.min(f(obstacles, mem, i + 1, a), f(obstacles, mem, i + 1, b)) + 1;
                } else {
                    ans = f(obstacles, mem, i + 1, obstacles[i] - 1 == a ? b : a) + 1;
                }
            }
        }
        return mem[i][j] = ans;
    }

}
