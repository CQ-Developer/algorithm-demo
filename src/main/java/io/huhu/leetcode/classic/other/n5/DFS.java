package io.huhu.leetcode.classic.other.n5;

class DFS implements Code {

    @Override
    public int solution(int[][] arr, int t) {
        int[][] f = new int[arr.length][t + 1];
        return dfs(arr, 0, t, f);
    }

    private int dfs(int[][] arr, int i, int j, int[][] f) {
        if (i == arr.length) {
            return 0;
        }
        if (f[i][j] != 0) {
            return f[i][j];
        }
        f[i][j] = dfs(arr, i + 1, j, f);
        if (arr[i][0] <= j) {
            f[i][j] = Integer.max(f[i][j], arr[i][1] + dfs(arr, i + 1, j - arr[i][0], f));
        }
        return f[i][j];
    }

}
