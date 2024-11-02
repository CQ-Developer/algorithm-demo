package io.huhu.leetcode.n983;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length - 1];
        int[] f = new int[n + 1];
        for (int i = 1, j = 0; i <= n; i++) {
            if (i == days[j]) {
                int a = costs[0] + (i >= 1 ? f[i - 1] : 0);
                int b = costs[1] + (i >= 7 ? f[i - 7] : 0);
                int c = costs[2] + (i >= 30 ? f[i - 30] : 0);
                f[i] = Math.min(a, Math.min(b, c));
                j++;
            } else {
                f[i] = f[i - 1];
            }
        }
        return f[n];
    }

}
