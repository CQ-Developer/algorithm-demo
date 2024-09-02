package io.huhu.leetcode.classic.other.n16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * <a href="https://www.luogu.com.cn/problem/P2014">
 * 选课
 * </a>
 */
class Best {

    private static final int MAXN = 301;

    private static final int[] HEAD = new int[MAXN];
    private static final int[] NEXT = new int[MAXN];
    private static final int[] TO = new int[MAXN];

    private static int dfnCnt;
    private static final int[] VALUE = new int[MAXN + 1];
    private static final int[] SIZE = new int[MAXN + 1];

    private static final int[] SCORES = new int[MAXN];

    private static final int[][] DP = new int[MAXN + 2][MAXN];

    public static void main(String[] args) throws Exception {
        try (var reader = new BufferedReader(new InputStreamReader(System.in)); var writer = new PrintWriter(new OutputStreamWriter(System.out))) {
            var tokenizer = new StreamTokenizer(reader);
            int n = read(tokenizer), m = read(tokenizer);
            init(n, m);
            addEdge(n, tokenizer);
            dfn(0);
            // dynamic programming
            for (int i = n + 1; i >= 2; i--) {
                for (int j = 1; j <= m; j++) {
                    DP[i][j] = Math.max(DP[i + 1][j - 1] + VALUE[i], DP[i + SIZE[i]][j]);
                }
            }
            writer.println(SCORES[0] + DP[2][m]);
        }
    }

    private static int dfn(int f) {
        int i = ++dfnCnt;
        VALUE[i] = SCORES[f];
        SIZE[i] = 1;
        for (int e = HEAD[f]; e > 0; e = NEXT[e]) {
            SIZE[i] += dfn(TO[e]);
        }
        return SIZE[i];
    }

    private static void addEdge(int n, StreamTokenizer tokenizer) throws Exception {
        int edge = 1;
        for (int i = 1; i <= n; i++) {
            int f = read(tokenizer);
            NEXT[edge] = HEAD[f];
            TO[edge] = i;
            HEAD[f] = edge++;
            SCORES[i] = read(tokenizer);
        }
    }

    private static void init(int n, int m) {
        dfnCnt = 0;
        Arrays.fill(HEAD, 0, n + 1, 0);
        Arrays.fill(DP[n + 2], 0, m + 1, 0);
    }

    private static int read(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

}
