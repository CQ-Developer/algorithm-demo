package io.huhu.leetcode.n5;

class DP implements Code {

    @Override
    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int i = 0, m = 1;
        boolean[] dp = new boolean[n];
        for (int l = n - 2; l >= 0; l--) {
            for (int r = n - 1; r >= l; r--) {
                dp[r] = c[l] == c[r] && (r - l < 2 || dp[r - 1]);
                if (dp[r] && r - l + 1 > m) {
                    i = l;
                    m = r - l + 1;
                }
            }
        }
        return s.substring(i, i + m);
    }

}
