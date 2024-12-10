package io.huhu.leetcode.n2008;

import io.huhu.AC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AC
class Memoization implements Solution {

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
        long[] mem = new long[n + 1];
        Arrays.fill(mem, -1);
        return f(g, 1, mem);
    }

    private long f(List<List<int[]>> g, int i, long[] mem) {
        if (i == g.size()) {
            return 0;
        }
        if (mem[i] != -1) {
            return mem[i];
        }
        long res = f(g, i + 1, mem);
        for (int[] next : g.get(i)) {
            res = Math.max(res, f(g, next[0], mem) + next[1]);
        }
        return mem[i] = res;
    }

}
