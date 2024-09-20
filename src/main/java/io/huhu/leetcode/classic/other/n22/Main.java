package io.huhu.leetcode.classic.other.n22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * <a href="https://www.luogu.com.cn/problem/P1759">
 * 通天之潜水
 * </a>
 */
class Main {

    private static final int N = 101;
    private static final int M = 201;

    private static int[] weight = new int[N];
    private static int[] resistance = new int[N];
    private static int[] time = new int[N];

    private static int[][] dp = new int[M][M];
    private static String[][] path = new String[M][M];

    public static void main(String[] args) throws Exception {
        try (var reader = new BufferedReader(new InputStreamReader(System.in)); var writer = new PrintWriter(System.out)) {
            var tokenizer = new StreamTokenizer(reader);
            int m = readInt(tokenizer), v = readInt(tokenizer), n = readInt(tokenizer);
            for (int i = 1; i <= n; i++) {
                weight[i] = readInt(tokenizer);
                resistance[i] = readInt(tokenizer);
                time[i] = readInt(tokenizer);
            }
            setup(m, v);
            f(n, m, v);
            writer.println(dp[m][v]);
            writer.println(path[m][v]);
        }
    }

    private static void f(int n, int m, int v) {
        String p;
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= weight[i]; j--) {
                for (int k = v; k >= resistance[i]; k--) {
                    if (path[j - weight[i]][k - resistance[i]] == null) {
                        p = String.valueOf(i);
                    } else {
                        p = path[j - weight[i]][k - resistance[i]] + " " + i;
                    }
                    if (dp[j - weight[i]][k - resistance[i]] + time[i] > dp[j][k]) {
                        dp[j][k] = dp[j - weight[i]][k - resistance[i]] + time[i];
                        path[j][k] = p;
                    } else if (dp[j - weight[i]][k - resistance[i]] + time[i] == dp[j][k]) {
                        if (p.compareTo(path[j][k]) < 0) {
                            path[j][k] = p;
                        }
                    }
                }
            }
        }
    }

    private static void setup(int m, int v) {
        for (int j = 1; j <= m; j++) {
            for (int k = 1; k <= v; k++) {
                dp[j][k] = 0;
                path[j][k] = null;
            }
        }
    }

    private static int readInt(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

}
