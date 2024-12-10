package io.huhu.leetcode.n2008;

import io.huhu.AC;

import java.util.Arrays;

@AC
class DynamicProgrammingBinarySearch implements Solution {

    @Override
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> a[1] - b[1]);
        int m = rides.length;
        long[] f = new long[m + 1];
        for (int i = 0; i < m; i++) {
            int j = binarySearch(rides, i, rides[i][0]);
            f[i + 1] = Math.max(f[i], f[j] + rides[i][1] - rides[i][0] + rides[i][2]);
        }
        return f[m];
    }

    private int binarySearch(int[][] rides, int r, int target) {
        int l = 0;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (rides[m][1] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

}
