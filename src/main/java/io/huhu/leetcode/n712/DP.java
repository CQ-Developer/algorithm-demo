package io.huhu.leetcode.n712;

class DP implements Code {

    @Override
    public int minimumDeleteSum(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int m = c1.length, n = c2.length;
        int[] f = new int[n + 1];
        f[n - 1] = c2[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            f[j] = f[j + 1] + c2[j];
        }
        for (int i = m - 1; i >= 0; i--) {
            int rd = f[n];
            f[n] += c1[i];
            for (int j = n - 1; j >= 0; j--) {
                int _rd = f[j];
                if (c1[i] == c2[j]) {
                    f[j] = rd;
                } else {
                    f[j] = Math.min(f[j] + c1[i], f[j + 1] + c2[j]);
                }
                rd = _rd;
            }
        }
        return f[0];
    }

}
