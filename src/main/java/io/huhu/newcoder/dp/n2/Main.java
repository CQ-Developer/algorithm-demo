package io.huhu.newcoder.dp.n2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * <a href="https://www.nowcoder.com/practice/4727c06b9ee9446cab2e859b4bb86bb8">
 * 最长公共子序列
 * </a>
 */
class Main {

    private static final int N = 5000;
    private static final int[][] DP = new int[N + 1][N + 1];
    private static final char[] ans = new char[N];

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); PrintWriter writer = new PrintWriter(System.out)) {
            char[] s1 = reader.readLine().toCharArray(), s2 = reader.readLine().toCharArray();
            f(s1, s2);
            recover(s1, s2);
            int n = DP[s1.length][s2.length];
            if (n == 0) {
                writer.println(-1);
            }
            writer.write(ans, 0, n);
            writer.println();
        }
    }

    private static void f(char[] s1, char[] s2) {
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }
    }

    private static void recover(char[] s1, char[] s2) {
        for (int i = s1.length, j = s2.length, len = DP[i][j]; len > 0;) {
            if (s1[i - 1] == s2[j - 1]) {
                ans[--len] = s1[i - 1];
                i--;
                j--;
            } else {
                if (DP[i - 1][j] >= DP[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
    }

}
