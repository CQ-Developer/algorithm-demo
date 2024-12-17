package io.huhu.leetcode.n2266;

class DynamicProgramming implements Solution {

    private static final int M = 1_000_000_007;

    private static final int N = 100_000;
    private static final long[] f = new long[N + 1];
    private static final long[] g = new long[N + 1];

    static {
        f[0] = g[0] = 1;
        f[1] = g[1] = 1;
        f[2] = g[2] = 2;
        f[3] = g[3] = 4;
        for (int i = 4; i <= N; i++) {
            f[i] = (f[i - 1] + f[i - 2] + f[i - 3]) % M;
            g[i] = (g[i - 1] + g[i - 2] + g[i - 3] + g[i - 4]) % M;
        }
    }

    @Override
    public int countTexts(String pressedKeys) {
        char[] c = pressedKeys.toCharArray();
        long res = 1;
        int n = c.length;
        for (int i = 0, cnt = 0; i < n; i++) {
            cnt++;
            if (i == n - 1 || c[i] != c[i + 1]) {
                res *= c[i] == '7' || c[i] == '9' ? g[cnt] : f[cnt];
                res %= M;
                cnt = 0;
            }
        }
        return (int) res;
    }

}
