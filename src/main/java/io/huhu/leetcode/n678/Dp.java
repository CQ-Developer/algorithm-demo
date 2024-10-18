package io.huhu.leetcode.n678;

class Dp implements Code {

    @Override
    public boolean checkValidString(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        boolean[][] f = new boolean[n + 1][n + 1];
        f[n][0] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (c[i] == '(') {
                    f[i][j] = f[i + 1][j + 1];
                } else if (c[i] == ')') {
                    if (j - 1 >= 0) {
                        f[i][j] = f[i + 1][j - 1];
                    }
                } else {
                    f[i][j] = f[i + 1][j] || f[i + 1][j + 1];
                    if (j - 1 >= 0) {
                        f[i][j] |= f[i + 1][j - 1];
                    }
                }
            }
        }
        return f[0][0];
    }

}
