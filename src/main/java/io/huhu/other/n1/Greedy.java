package io.huhu.other.n1;

class Greedy implements Code {

    private static final int M = 1000000007;

    @Override
    public int max(int n, int k) {
        /*
         * n = 10, k = 3
         *
         * a = 10 / 3 = 3
         * b = 10 % 3 = 1
         *
         * 3 3 3
         * 1
         *
         * ans1 = 4 ^ 1
         * ans2 = 3 ^ 2
         */
        long a = n / k, b = n % k;
        long ans1 = f(a + 1, b);
        long ans2 = f(a, k - b);
        return (int) (ans1 * ans2) % M;
    }

    private long f(long x, long n) {
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
