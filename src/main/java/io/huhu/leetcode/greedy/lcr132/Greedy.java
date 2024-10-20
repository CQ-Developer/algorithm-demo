package io.huhu.leetcode.greedy.lcr132;

class Greedy implements Code {

    private static final int M = 1000000007;

    @Override
    public int cuttingBamboo(int bamboo_len) {
        if (bamboo_len == 2) {
            return 1;
        }
        if (bamboo_len == 3) {
            return 2;
        }
        int tail = bamboo_len % 3 == 0 ? 1 : bamboo_len % 3 == 1 ? 4 : 2;
        int power = (tail == 1 ? bamboo_len : bamboo_len - tail) / 3;
        return (int) (f(3, power) * tail % M);
    }

    /**
     * 快速幂
     */
    private long f(long x, int n) {
        long ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = (ans * x) % M;
            }
            x = (x * x) % M;
            n >>= 1;
        }
        return ans;
    }

}
