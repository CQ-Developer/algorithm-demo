package io.huhu.leetcode.n926;

/**
 * TLE
 */
class DynamicProgramming implements Code {

    @Override
    public int minFlipsMonoIncr(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] f = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int leftDown = i - 1 < 0 ? 0 : f[i - 1];
            f[i + 1] = c[i] <= c[i + 1] ? 0 : 1;
            for (int j = i + 2; j < n; j++) {
                int _leftDown = f[j];
                if (c[i] == c[j]) {
                    f[j] = Math.min(leftDown + 1, c[i] == '0' ? f[j] : f[j - 1]);
                } else {
                    f[j] = c[i] == '0' ? leftDown : Math.min(f[j] + 1, f[j - 1] + 1);
                }
                leftDown = _leftDown;
            }
        }
        return f[n - 1];
    }

}
