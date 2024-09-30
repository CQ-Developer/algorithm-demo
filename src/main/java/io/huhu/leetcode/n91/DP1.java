package io.huhu.leetcode.n91;

class DP1 implements Code {

    @Override
    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int x = 0, y = 1;
        for (int i = n - 1; i >= 0; i--) {
            int t = 0;
            if (c[i] != '0') {
                t += y;
                if (i + 1 < n && (c[i] - '0') * 10 + (c[i + 1] - '0') <= 26) {
                    t += x;
                }
            }
            x = y;
            y = t;
        }
        return y;
    }

}
