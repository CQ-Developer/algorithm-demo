package io.huhu.leetcode.dynamic.programming.medium.interview08.n14;

class DFS implements Solution {

    @Override
    public int countEval(String s, int result) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] ans = dfs(c, 0, n - 1, new int[n][n][]);
        return ans[result];
    }

    private int[] dfs(char[] s, int i, int j, int[][][] m) {
        if (m[i][j] != null) {
            return m[i][j];
        }
        int f = 0, t = 0;
        if (i == j) {
            f = s[i] == '0' ? 1 : 0;
            t = s[i] == '1' ? 1 : 0;
        } else {
            for (int k = i + 1; k < j; k += 2) {
                int[] l = dfs(s, i, k - 1, m);
                int[] r = dfs(s, k + 1, j, m);
                int a = l[0], b = l[1];
                int c = r[0], d = r[1];
                switch (s[k]) {
                    case '&' -> {
                        f += a * c + a * d + c * b;
                        t += b * d;
                    }
                    case '|' -> {
                        f += a * c;
                        t += a * d + c * b + d * b;
                    }
                    default -> {
                        f += a * c + b * d;
                        t += a * d + c * b;
                    }
                }
            }
        }
        return m[i][j] = new int[]{f, t};
    }

}
