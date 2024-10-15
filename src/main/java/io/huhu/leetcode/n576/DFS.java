package io.huhu.leetcode.n576;

class DFS implements Code {

    private static final int M = 1000000007;

    @Override
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return f(m, n, maxMove, startRow, startColumn);
    }

    private int f(int m, int n, int s, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        int ans = 0;
        if (s != 0) {
            ans += f(m, n, s - 1, i + 1, j);
            ans += f(m, n, s - 1, i - 1, j);
            ans += f(m, n, s - 1, i, j + 1);
            ans += f(m, n, s - 1, i, j - 1);
        }
        return ans % M;
    }

}
