package io.huhu.leetcode.n1986;

import io.huhu.AC;

@AC
class Memoization implements Solution {

    @Override
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        return f(tasks, n, sessionTime, 0, 0, new int[1 << n][sessionTime + 1]);
    }

    private int f(int[] tasks, int n, int sessionTime, int status, int time, int[][] mem) {
        if (((1 << n) - 1 ^ status) == 0) {
            return 1;
        }
        if (mem[status][time] != 0) {
            return mem[status][time];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if ((status & (1 << i)) == 0) {
                if (time + tasks[i] <= sessionTime) {
                    res = Math.min(res, f(tasks, n, sessionTime, status | (1 << i), time + tasks[i], mem));
                } else {
                    res = Math.min(res, f(tasks, n, sessionTime, status, 0, mem) + 1);
                }
            }
        }
        return mem[status][time] = res;
    }

}
