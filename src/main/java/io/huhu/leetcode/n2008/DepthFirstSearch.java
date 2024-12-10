package io.huhu.leetcode.n2008;

import io.huhu.TLE;

import java.util.ArrayList;
import java.util.List;

@TLE
class DepthFirstSearch implements Solution {

    @Override
    public long maxTaxiEarnings(int n, int[][] rides) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] ride : rides) {
            int u = ride[0], v = ride[1], t = ride[2];
            g.get(u).add(new int[]{v, v - u + t});
        }
        return f(g, 1);
    }

    private long f(List<List<int[]>> g, int i) {
        if (i == g.size()) {
            return 0;
        }
        long res = f(g, i + 1);
        for (int[] next : g.get(i)) {
            res = Math.max(res, f(g, next[0]) + next[1]);
        }
        return res;
    }

}
