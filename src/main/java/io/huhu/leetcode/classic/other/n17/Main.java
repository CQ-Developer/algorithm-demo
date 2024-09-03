package io.huhu.leetcode.classic.other.n17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * <a href="https://www.luogu.com.cn/problem/P1171">
 * 售货员的难题
 * </a>
 */
class Main {

    private static final int MAXN = 20;

    private static int n;
    private static final int[][] GRAPH = new int[MAXN][MAXN];
    private static final int[][] DP = new int[1 << MAXN][MAXN];

    public static void main(String[] args) throws Exception {
        try (var reader = new BufferedReader(new InputStreamReader(System.in)); var writer = new PrintWriter(new OutputStreamWriter(System.out))) {
            var tokenizer = new StreamTokenizer(reader);
            n = read(tokenizer);
            init(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    GRAPH[i][j] = read(tokenizer);
                }
            }
            writer.println(f(1, 0));
        }
    }

    private static int f(int status, int i) {
        if (status == (1 << n) - 1) {
            return GRAPH[i][0];
        }
        if (DP[status][i] != -1) {
            return DP[status][i];
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if ((status & (1 << j)) == 0) {
                ans = Math.min(ans, GRAPH[i][j] + f(status | (1 << j), j));
            }
        }
        return DP[status][i] = ans;
    }

    private static void init(int n) {
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                DP[i][j] = -1;
            }
        }
    }

    private static int read(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

}
