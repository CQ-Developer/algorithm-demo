package io.huhu.leetcode.dynamic.programming.medium.interview08.n14;

class DP implements Solution {

    @Override
    public int countEval(String s, int result) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][][] dp = new int[n][n][];
        for (int i = 0; i < n; i++) {
            int f = chars[i] == '0' ? 1 : 0;
            int t = chars[i] == '1' ? 1 : 0;
            dp[i][i] = new int[]{f, t};
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int f = 0, t = 0;
                for (int k = i + 1; k < j; k++) {
                    int[] l = dp[i][k - 1], r = dp[k + 1][j];
                    int a = l[0], b = l[1];
                    int c = r[0], d = r[1];
                    switch (chars[k]) {
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
                dp[i][j] = new int[]{f, t};
            }
        }
        return dp[0][n - 1][result];
    }

}
