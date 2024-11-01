package io.huhu.leetcode.n935;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    private static final int M = 1000000007;

    @Override
    public int knightDialer(int n) {
        if (n < 2) {
            return 10;
        }
        long n0 = 1, n1 = 1, n2 = 1, n3 = 1, n4 = 1, n6 = 1, n7 = 1, n8 = 1, n9 = 1;
        for (int i = 2; i <= n; i++) {
            long _n0 = (n4 + n6) % M;
            long _n1 = (n6 + n8) % M;
            long _n2 = (n7 + n9) % M;
            long _n3 = (n4 + n8) % M;
            long _n4 = (n0 + n3 + n9) % M;
            long _n6 = (n0 + n1 + n7) % M;
            long _n7 = (n2 + n6) % M;
            long _n8 = (n1 + n3) % M;
            long _n9 = (n2 + n4) % M;
            n0 = _n0;
            n1 = _n1;
            n2 = _n2;
            n3 = _n3;
            n4 = _n4;
            n6 = _n6;
            n7 = _n7;
            n8 = _n8;
            n9 = _n9;
        }
        int ans = 0;
        ans = (ans + (int) n0) % M;
        ans = (ans + (int) n1) % M;
        ans = (ans + (int) n2) % M;
        ans = (ans + (int) n3) % M;
        ans = (ans + (int) n4) % M;
        ans = (ans + (int) n6) % M;
        ans = (ans + (int) n7) % M;
        ans = (ans + (int) n8) % M;
        ans = (ans + (int) n9) % M;
        return ans;
    }

}
