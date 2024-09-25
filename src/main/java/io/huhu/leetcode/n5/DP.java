package io.huhu.leetcode.n5;

class DP implements Code {

    @Override
    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        if (n < 2) {
            return s;
        }
        int i = 0, j = 0, m = 1;
        boolean[][] dp = new boolean[n][n];
        for (int r = 1; r < n; r++) {
            for (int l = 0; l < r; l++) {
                if (c[l] == c[r] && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > m) {
                        m = r - l + 1;
                        i = l;
                        j = r;
                    }
                }
            }
        }
        return s.substring(i, j + 1);
    }

}
