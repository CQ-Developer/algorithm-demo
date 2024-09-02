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

    private static final int[] head = new int[MAXN];
    private static final int[] next = new int[MAXN];
    private static final int[] to = new int[MAXN];

    private static int dfnCnt;
    private static final int[] value = new int[MAXN + 1];
    private static final int[] size = new int[MAXN + 1];

    private static final int[] scores = new int[MAXN];

    private static final int[][] dp = new int[MAXN + 2][MAXN];

    public static void main(String[] args) throws Exception {
        try (var reader = new BufferedReader(new InputStreamReader(System.in)); var writer = new PrintWriter(new OutputStreamWriter(System.out))) {
            var tokenizer = new StreamTokenizer(reader);
            int n = read(tokenizer), m = read(tokenizer);
            init(n, m);
            addEdge(n, tokenizer);
            dfn(0);
            for (int i = n + 1; i >= 2; i--) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = Math.max(dp[i + 1][j - 1] + value[i], dp[i + size[i]][j]);
                }
            }
            writer.println(scores[0] + dp[2][m]);
        }
    }

    private static int dfn(int f) {
        int i = ++dfnCnt;
        value[i] = scores[f];
        size[i] = 1;
        for (int e = head[f]; e > 0; e = next[e]) {
            size[i] += dfn(to[e]);
        }
        return size[i];
    }

    private static void addEdge(int n, StreamTokenizer tokenizer) throws Exception {
        int edge = 1;
        for (int i = 1; i <= n; i++) {
            int f = read(tokenizer);
            next[edge] = head[f];
            to[edge] = i;
            head[f] = edge++;
            scores[i] = read(tokenizer);
        }
    }

    private static void init(int n, int m) {
        dfnCnt = 0;
        Arrays.fill(head, 0, n + 1, 0);
        Arrays.fill(dp[n + 2], 0, m + 1, 0);
    }

    private static int read(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

}
