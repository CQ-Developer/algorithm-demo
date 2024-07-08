package io.huhu.leetcode.binary.search.hard.n878;

/**
 * <a href="https://leetcode.cn/problems/nth-magical-number/description/">
 * Nth Magical Number
 * </a>
 */
class Solution {

    public int nthMagicalNumber(int n, int a, int b) {
        long l = 1, r = n * Long.min(a, b), c = lcm(a, b), ans = 0;
        while (l <= r) {
            long m = (l + r) >> 1;
            if (m / a + m / b - m / c >= n) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return (int) (ans % 1000000007);
    }

    // 最大公倍数
    private long lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    // 最小公约数
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
