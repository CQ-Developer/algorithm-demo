package io.huhu.leetcode.n678;

class Dfs implements Code {

    @Override
    public boolean checkValidString(String s) {
        char[] c = s.toCharArray();
        return f(c, 0, 0);
    }

    /**
     * f(i,j)表示来到第i个字符当前有j对括号是否合法
     * c[i] == '(' -> j + 1
     * c[i] == ')' -> j - 1
     * c[i] == '*' -> j || j + 1 || j - 1
     */
    private boolean f(char[] c, int i, int j) {
        if (j < 0) {
            return false;
        }
        if (i == c.length) {
            return j == 0;
        }
        if (c[i] == '(') {
            return f(c, i + 1, j + 1);
        }
        if (c[i] == ')') {
            return f(c, i + 1, j - 1);
        }
        return f(c, i + 1, j) || f(c, i + 1, j + 1) || f(c, i + 1, j - 1);
    }

}
