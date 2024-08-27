package io.huhu.leetcode.classic.other.n14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * <a href="https://www.luogu.com.cn/problem/P4017">
 * 最大食物链计数
 * </a>
 */
class Main {

    static final int MOD = 80112002;

    static final int MAXN = 5001;
    static final int MAXM = 500001;

    // graph
    static int edge;
    static int[] head = new int[MAXN];
    static int[] next = new int[MAXM];
    static int[] to = new int[MAXM];

    // indegress
    static int[] indegress = new int[MAXN];

    // queue
    static int[] queue = new int[MAXN];

    // accumulation
    static int[] path = new int[MAXN];

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); PrintWriter writer = new PrintWriter(System.out)) {
            StreamTokenizer tokenizer = new StreamTokenizer(reader);
            int n = readInt(tokenizer), m = readInt(tokenizer);
            init(n);
            for (int i = 0; i < m; i++) {
                int f = readInt(tokenizer), t = readInt(tokenizer);
                buildGraph(f, t);
                indegress[t]++;
            }
            writer.println(topologicalSort(n));
        }
    }

    private static void init(int n) {
        edge = 1;
        Arrays.fill(head, 1, n + 1, 0);
        Arrays.fill(indegress, 1, n + 1, 0);
        Arrays.fill(path, 1, n + 1, 0);
    }

    private static int readInt(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

    private static void buildGraph(int f, int t) {
        next[edge] = head[f];
        to[edge] = t;
        head[f] = edge++;
    }

    private static int topologicalSort(int n) {
        int l = 0, r = 0;
        for (int i = 1; i <= n; i++) {
            if (indegress[i] == 0) {
                queue[r++] = i;
                path[i] = 1;
            }
        }
        int ans = 0;
        while (l < r) {
            int f = queue[l++];
            if (head[f] == 0) {
                ans = (ans + path[f]) % MOD;
            } else {
                for (int e = head[f]; e > 0; e = next[e]) {
                    int t = to[e];
                    path[t] = (path[t] + path[f]) % MOD;
                    if (--indegress[t] == 0) {
                        queue[r++] = t;
                    }
                }
            }
        }
        return ans;
    }

}
