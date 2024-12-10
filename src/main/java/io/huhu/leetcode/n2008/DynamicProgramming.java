package io.huhu.leetcode.n2008;

import java.util.ArrayList;
import java.util.List;

class DynamicProgramming implements Solution {

    @Override
    public long maxTaxiEarnings(int n, int[][] rides) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] ride : rides) {
            g.get(ride[0]).add(new int[]{ride[1], ride[1] - ride[0] + ride[2]});
        }
        long[] f = new long[n + 1];
        for (int i = n - 1; i >= 1; i--) {
            long res = f[i + 1];
            for (int[] next : g.get(i)) {
                res = Math.max(res, f[next[0]] + next[1]);
            }
            f[i] = res;
        }
        return f[1];
    }

}
