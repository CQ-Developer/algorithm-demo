package io.huhu.leetcode.dynamic.programming.medium.n91;

class DP extends Solution {

    @Override
    public int numDecodings(String s) {
        int a = 1, b = 0;
        for (int i = s.length() - 1, c; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                c = 0;
            } else {
                 c = a;
                if (i + 1 < s.length() && ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0')) <= 26) {
                    c += b;
                }
            }
            b = a;
            a = c;
        }
        return a;
    }

}
