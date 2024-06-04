package io.huhu.leetcode.dynamic.programming.core.ugly.number.n1201;

/**
 * <a href="https://leetcode.cn/problems/ugly-number-iii/description/">丑数III</a>
 */
class Solution {

    public int nthUglyNumber(int n, int a, int b, int c) { int l = 1, r = Integer.MAX_VALUE; while (l < r) {
            int m = l + ((r - l) >> 1);
            if (check(m, n, a, b, c)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

    private boolean check(int m, int n, int a, int b, int c) {
        long ab = lcm(a, b), ac = lcm(a, c), bc = lcm(b, c), abc = lcm(lcm(a, b), c);
        long count = m / a + m / b + m / c - m / ab - m / ac - m / bc + m / abc;
        return count >= n;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
