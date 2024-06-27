package io.huhu.leetcode.dynamic.programming.medium.n639;

final class DPSolution extends Solution {

    @Override
    public int numDecodings(String s) {
        char[] cs = s.toCharArray();
        long a = 1, b = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            long c = 0;
            if (cs[i] != '0') {
                c = a * (cs[i] == '*' ? 9 : 1);
                if (i + 1 < cs.length) {
                    if (cs[i] == '*') {
                        if (cs[i + 1] == '*') {
                            c += b * 15;
                        } else {
                            if (cs[i + 1] <= '6') {
                                c += b * 2;
                            } else {
                                c += b;
                            }
                        }
                    } else {
                        if (cs[i + 1] == '*') {
                            if (cs[i] == '1') {
                                c += b * 9;
                            } else if (cs[i] == '2') {
                                c += b * 6;
                            }
                        } else {
                            if ((cs[i] - '0') * 10 + (cs[i + 1] - '0') <= 26) {
                                c += b;
                            }
                        }
                    }
                }
                c %= 1000000007;
            }
            b = a;
            a = c;
        }
        return (int) a;
    }

}
