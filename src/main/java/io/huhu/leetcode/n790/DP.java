package io.huhu.leetcode.n790;

class DP implements Code {

    private static final int M = 1000000007;

    /**
     * f[1] = 1
     * f[2] = 2
     * f[3] = f[2] + f[1] + 2 = 5
     * f[4] = f[3] + f[2] + 2 * (f[1] + 1) = 11
     * f[5] = f[4] + f[3] + 2 * (f[2] + f[1] + 1) = 24
     * f[n-1] = f[n-2] + f[n-3] + 2 * (f[n-4] + ... + f[1] + 1)
     * f[n] = f[n-1] + f[n-2] + 2 * (f[n-3] + ... + f[1] + 1)
     * f[n] - f[n-1] = f[n-1] + f[n-3]
     * f[n] = 2 * f[n-1] + f[n-3]
     */
    @Override
    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        long a = 1, b = 1, c = 2;
        for (int i = 3; i <= n; i++) {
            long t = (2 * c + a) % M;
            a = b;
            b = c;
            c = t;
        }
        return (int) c;
    }

}
