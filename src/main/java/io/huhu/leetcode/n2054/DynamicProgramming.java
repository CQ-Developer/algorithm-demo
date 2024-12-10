package io.huhu.leetcode.n2054;

import io.huhu.AC;

import java.util.Arrays;

@AC
class DynamicProgramming implements Solution {

    @Override
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, this::compare);
        int n = events.length;
        // f[i][j]表示0...i范围上选择j次最大收益
        int[][] f = new int[n][3];
        for (int i = 0; i < n; i++) {
            int l = 0, r = i - 1, k = -1;
            while (l <= r) {
                int m = (l + r) >> 1;
                if (events[m][1] < events[i][0]) {
                    k = m;
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            for (int j = 1; j <= 2; j++) {
                f[i][j] = k == -1 ? events[i][2] : events[i][2] + f[k][j - 1];
                if (i > 0) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                }
            }
        }
        return f[n - 1][2];
    }

    private int compare(int[] a, int[] b) {
        return a[1] - b[1];
    }

}
