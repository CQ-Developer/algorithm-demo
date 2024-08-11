package io.huhu.leetcode.classic.other.n11;

import java.util.Scanner;

/**
 * <a href="https://www.nowcoder.com/practice/e391767d80d942d29e6095a935a5b96b">
 * 括号区间匹配
 * </a>
 */
class DP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] c = s.toCharArray();
        int ans = dp(c, c.length);
        System.out.println(ans);
    }

    private static int dp(char[] s, int n) {
        int[][] dp = new int[n][n];
        // init
        for (int i = 0; i < n - 1; i++) {
            dp[i][i] = 1;
            if (!((s[i] == '(' && s[i + 1] == ')') || (s[i] == '[' && s[i + 1] == ']'))) {
                dp[i][i + 1] = 2;
            }
        }
        dp[n - 1][n - 1] = 1;
        // dp
        for (int l = n - 2; l >= 0; l--) {
            for (int r = l + 1; r < n; r++) {
                int p1 = Integer.MAX_VALUE;
                if ((s[l] == '(' && s[r] == ')') || (s[l] == '[' && s[r] == ']')) {
                    p1 = dp[l + 1][r - 1];
                }
                int p2 = Integer.MAX_VALUE;
                for (int i = l; i < r; i++) {
                    p2 = Integer.min(p2, dp[l][i] + dp[i + 1][r]);
                }
                dp[l][r] = Math.min(p1, p2);
            }
        }
        // ans
        return dp[0][n - 1];
    }

}
