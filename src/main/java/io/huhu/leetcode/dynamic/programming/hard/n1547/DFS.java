package io.huhu.leetcode.dynamic.programming.hard.n1547;

import java.util.Arrays;

class DFS implements Solution {

    @Override
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        int[] arr = new int[m + 2];
        System.arraycopy(cuts, 0, arr, 1, m);
        arr[m + 1] = n;
        int[][] f = new int[m + 1][m + 1];
        for (int[] a : f) {
            Arrays.fill(a, -1);
        }
        return dfs(arr, 1, m, f);
    }

    private int dfs(int[] arr, int l, int r, int[][] f) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            return arr[r + 1] - arr[l - 1];
        }
        if (f[l][r] != -1) {
            return f[l][r];
        }
        f[l][r] = Integer.MAX_VALUE;
        for (int k = l; k <= r; k++) {
            f[l][r] = Math.min(f[l][r], dfs(arr, l, k - 1, f) + dfs(arr, k + 1, r, f));
        }
        return f[l][r] += arr[r + 1] - arr[l - 1];
    }

}
