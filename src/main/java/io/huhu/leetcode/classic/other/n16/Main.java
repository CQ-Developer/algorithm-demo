package io.huhu.leetcode.classic.other.n16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.luogu.com.cn/problem/P2014">
 * 选课
 * </a>
 */
class Main {

    private static final int MAXN = 301;

    private static final int[][][] dp = new int[MAXN][][];
    private static final int[] scores = new int[MAXN];
    private static final List<List<Integer>> graph = new ArrayList<>();

    static {
        for (int i = 0; i < MAXN; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) throws Exception {
        try (var reader = new BufferedReader(new InputStreamReader(System.in)); var writer = new PrintWriter(new OutputStreamWriter(System.out))) {
            var tokenizer = new StreamTokenizer(reader);
            int n = readInt(tokenizer), m = readInt(tokenizer) + 1;
            buildGraph(n);
            for (int i = 1; i <= n; i++) {
                graph.get(readInt(tokenizer)).add(i);
                scores[i] = readInt(tokenizer);
            }
            init(n, m);
            int ans = f(0, graph.get(0).size(), m);
            writer.println(ans);
        }
    }

    /**
     * 在以i为头节点的前j棵子树中选k门课, 能够获得的最大收益.
     */
    private static int f(int i, int j, int k) {
        if (k == 0) {
            return 0;
        }
        if (j == 0 || k == 1) {
            return scores[i];
        }
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        int ans = f(i, j - 1, k);
        int v = graph.get(i).get(j - 1);
        for (int s = 1; s < k; s++) {
            ans = Math.max(ans, f(i, j - 1, k - s) + f(v, graph.get(v).size(), s));
        }
        return dp[i][j][k] = ans;
    }

    private static void init(int n, int m) {
        for (int i = 0; i <= n; i++) {
            dp[i] = new int[graph.get(i).size() + 1][m + 1];
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k <= m; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
    }

    private static void buildGraph(int n) {
        for (int i = 0; i <= n; i++) {
            graph.get(i).clear();
        }
    }

    private static int readInt(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

}
