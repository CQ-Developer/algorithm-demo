package io.huhu.leetcode.classic.other.n15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * <a href="https://www.luogu.com.cn/problem/P1352">
 * 没有上司的舞会
 * </a>
 */
class Main {

    static final int MAXN = 6001;

    static int[] happy = new int[MAXN];
    static boolean[] boss = new boolean[MAXN];
    static int[] yes = new int[MAXN];
    static int[] no = new int[MAXN];

    static int edge;
    static int[] head = new int[MAXN];
    static int[] next = new int[MAXN];
    static int[] to = new int[MAXN];

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); PrintWriter writer = new PrintWriter(System.out)) {
            StreamTokenizer tokenizer = new StreamTokenizer(reader);
            int n = readInt(tokenizer);
            init(n);
            for (int i = 1; i <= n; i++) {
                happy[i] = readInt(tokenizer);
            }
            for (int i = 1; i < n; i++) {
                int t = readInt(tokenizer), f = readInt(tokenizer);
                buildGraph(f, t);
                boss[t] = false;
            }
            int h = findHead(n);
            dfs(h);
            writer.println(Math.max(yes[h], no[h]));
        }
    }

    private static int readInt(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

    private static void init(int n) {
        edge = 1;
        Arrays.fill(head, 1, n + 1, 0);
        Arrays.fill(boss, 1, n + 1, true);
    }

    private static void buildGraph(int f, int t) {
        next[edge] = head[f];
        to[edge] = t;
        head[f] = edge++;
    }

    private static int findHead(int n) {
        int h = 0;
        for (int i = 1; i <= n; i++) {
            if (boss[i]) {
                h = i;
                break;
            }
        }
        return h;
    }

    private static void dfs(int f) {
        no[f] = 0;
        yes[f] = happy[f];
        for (int e = head[f]; e > 0; e = next[e]) {
            int t = to[e];
            dfs(t);
            yes[f] += no[t];
            no[f] += Math.max(yes[t], no[t]);
        }
    }

}
