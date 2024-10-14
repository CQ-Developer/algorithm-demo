package io.huhu.leetcode.n474;

class DP implements Code {

    @Override
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[] one = new int[len], zero = new int[len];
        for (int i = 0; i < len; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    zero[i]++;
                } else {
                    one[i]++;
                }
            }
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int s = 0; s < len; s++) {
            for (int i = m; i >= zero[s]; i--) {
                for (int j = n; j >= one[s]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero[s]][j - one[s]] + 1);
                }
            }
        }
        return dp[m][n];
    }

}
