package io.huhu.leetcode.n97;

class DFS implements Code {

    @Override
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        if (c1.length + c2.length != c3.length) {
            return false;
        }
        return f(new boolean[c1.length + 1][c2.length + 1], c1, 0, c2, 0, c3, 0);
    }

    /**
     * c3[k]要不由c1[i]交错而来, 要不由c2[j]交错而来
     * f(i,j,k) = f(i+1,j,k+1) || f(i,j+1,k+1)
     */
    private boolean f(boolean[][] dp, char[] c1, int i, char[] c2, int j, char[] c3, int k) {
        if (k == c3.length) {
            return true;
        }
        if (dp[i][j]) {
            return false;
        }
        dp[i][j] = true;
        if (i < c1.length && c1[i] == c3[k] && f(dp, c1, i + 1, c2, j, c3, k + 1)) {
            return true;
        }
        if (j < c2.length && c2[j] == c3[k] && f(dp, c1, i, c2, j + 1, c3, k + 1)) {
            return true;
        }
        return false;
    }

}
