package io.huhu.leetcode.classic.other.n13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * <a href="https://www.luogu.com.cn/problem/U107394">
 * 拓扑排序模板
 * </a>
 */
class Main {

    static final int MAXN = 100001;

    // 链式前向星
    static int edge;
    static int[] head = new int[MAXN];
    static int[] next = new int[MAXN];
    static int[] to = new int[MAXN];

    // 拓扑排序
    static int[] indegress = new int[MAXN];

    // 小根堆
    static int heapSize;
    static int[] heap = new int[MAXN];

    // 结果集
    static int[] ans = new int[MAXN];

    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out))) {
            StreamTokenizer tokenizer = new StreamTokenizer(reader);
            tokenizer.nextToken();
            n = (int) tokenizer.nval;
            tokenizer.nextToken();
            m = (int) tokenizer.nval;
            init();
            for (int i = 0; i < m; i++) {
                tokenizer.nextToken();
                int f = (int) tokenizer.nval;
                tokenizer.nextToken();
                int t = (int) tokenizer.nval;
                buildGraph(f, t);
                indegress[t]++;
            }
            topologicalSort();
            for (int i = 0; i < n - 1; i++) {
                writer.print(ans[i] + " ");
            }
            writer.println(ans[n - 1]);
        }
    }

    private static void buildGraph(int f, int t) {
        next[edge] = head[f];
        to[edge] = t;
        head[f] = edge++;
    }

    static void topologicalSort() {
        for (int i = 1; i <= n; i++) {
            if (indegress[i] == 0) {
                push(i);
            }
        }
        int i = 0;
        while (!isEmpty()) {
            int cur = pop();
            ans[i++] = cur;
            for (int ei = head[cur]; ei != 0; ei = next[ei]) {
                if (--indegress[to[ei]] == 0) {
                    push(to[ei]);
                }
            }
        }
    }

    static void push(int num) {
        int i = heapSize++;
        heap[i] = num;
        while (heap[i] < heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    static int pop() {
        int num = heap[0];
        heap[0] = heap[--heapSize];
        int i = 0, l = 1;
        while (l < heapSize) {
            int best = l + 1 < heapSize && heap[l + 1] < heap[l] ? l + 1 : l;
            best = heap[best] < heap[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(best, i);
            i = best;
            l = i * 2 + 1;
        }
        return num;
    }

    static void swap(int i, int j) {
        int num = heap[i];
        heap[i] = heap[j];
        heap[j] = num;
    }

    static boolean isEmpty() {
        return heapSize == 0;
    }

    static void init() {
        edge = 1;
        heapSize = 0;
        Arrays.fill(indegress, 0, n + 1, 0);
        Arrays.fill(head, 0, n + 1, 0);
    }

}
