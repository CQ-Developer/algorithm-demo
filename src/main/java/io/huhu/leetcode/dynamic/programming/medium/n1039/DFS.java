package io.huhu.leetcode.dynamic.programming.medium.n1039;

class DFS implements Solution {

    @Override
    public int minScoreTriangulation(int[] values) {
        return dfs(values, 0, values.length - 1);
    }

    private int dfs(int[] v, int l, int r) {
        if (l == r || l + 1 == r) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int m = l + 1; m < r; m++) {
            ans = Integer.min(ans, dfs(v, l, m) + dfs(v, m, r) + v[l] * v[m] * v[r]);
        }
        return ans;
    }

}
