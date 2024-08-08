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
        return dfs(arr, 1, m);
    }

    private int dfs(int[] arr, int l, int r) {
        if (l > r) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int m = l; m <= r; m++) {
            ans = Math.min(ans, dfs(arr, l, m - 1) + dfs(arr, m + 1, r) + arr[r + 1] - arr[l - 1]);
        }
        return ans;
    }

}
