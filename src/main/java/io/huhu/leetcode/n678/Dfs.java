package io.huhu.leetcode.n678;

class Dfs implements Code {

    @Override
    public boolean checkValidString(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        return f(c, 0, 0, new int[n][n]);
    }

    /**
     * f(i,j)表示来到第i个字符当前有j对括号是否合法
     * c[i] == '(' -> j + 1
     * c[i] == ')' -> j - 1
     * c[i] == '*' -> j || j + 1 || j - 1
     */
    private boolean f(char[] c, int i, int j, int[][] m) {
        if (j < 0) {
            return false;
        }
        if (i == c.length) {
            return j == 0;
        }
        if (m[i][j] != 0) {
            return m[i][j] == 1;
        }
        boolean ans = switch (c[i]) {
            case '(' -> f(c, i + 1, j + 1, m);
            case ')' -> f(c, i + 1, j - 1, m);
            default -> f(c, i + 1, j, m) || f(c, i + 1, j + 1, m) || f(c, i + 1, j - 1, m);
        };
        m[i][j] = ans ? 1 : -1;
        return ans;
    }

}
