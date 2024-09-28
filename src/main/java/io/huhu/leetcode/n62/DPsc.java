package io.huhu.leetcode.n62;

class DPsc implements Code {

    @Override
    public int uniquePaths(int m, int n) {
        int[] pre = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            pre[j] = 1;
        }
        int[] cur = new int[n + 1];
        for (int i = m - 1; i >= 1; i--) {
            cur[n] = 1;
            for (int j = n - 1; j >= 1; j--) {
                cur[j] = pre[j] + cur[j + 1];
            }
            pre = cur;
        }
        return pre[1];
    }

}
