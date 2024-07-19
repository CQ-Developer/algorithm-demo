package io.huhu.leetcode.dynamic.programming.hard.n354;

import java.util.Arrays;

/**
 * timeout!
 */
class DFS implements Solution {

    @Override
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int ans = 0;
        int[] f = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            ans = Integer.max(ans, dfs(envelopes, i, f));
        }
        return ans;
    }

    private int dfs(int[][] envelopes, int j, int[] f) {
        if (f[j] != 0) {
            return f[j];
        }
        for (int i = 0; i < j; i++) {
            if (envelopes[j][1] > envelopes[i][1]) {
                f[j] = Integer.max(f[j], dfs(envelopes, i, f));
            }
        }
        return ++f[j];
    }

}
