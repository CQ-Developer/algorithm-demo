package io.huhu.leetcode.n1690;

class DynamicProgramming implements Code {

    @Override
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + stones[i];
        }
        int[] f = new int[n];
        for (int l = n - 1; l >= 0; l--) {
            f[l] = 0;
            for (int r = l + 1; r < n; r++) {
                f[r] = Math.max(pre[r + 1] - pre[l + 1] - f[r], pre[r] - pre[l] - f[r - 1]);
            }
        }
        return f[n - 1];
    }

}
