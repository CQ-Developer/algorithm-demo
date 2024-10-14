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
        for (int i = 0; i < len; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j >= zero[i] && k >= one[i]) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - zero[i]][k - one[i]] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }

}
