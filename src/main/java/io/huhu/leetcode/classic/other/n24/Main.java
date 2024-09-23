package io.huhu.leetcode.classic.other.n24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * <a href="https://www.luogu.com.cn/problem/P1439">
 * 最长公共子序列
 * </a>
 */
class Main {

    private static final int N = 100001;

    private static int[] a = new int[N];
    private static int[] b = new int[N];
    private static int[] end = new int[N];

    public static void main(String[] args) throws Exception {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var tokenizer = new StreamTokenizer(reader);
            int n = readInt(tokenizer);
            for (int i = 0; i < n; i++) {
                a[readInt(tokenizer)] = i;
            }
            for (int i = 0; i < n; i++) {
                b[i] = a[readInt(tokenizer)];
            }
            int ans = f(n);
            try (var writer = new PrintWriter(System.out)) {
                writer.println(ans);
            }
        }
    }

    private static int f(int n) {
        int len = 0;
        for (int i = 0; i < n; i++) {
            int j = find(len, i);
            if (j == -1) {
                end[len++] = b[i];
            } else {
                end[j] = b[i];
            }
        }
        return len;
    }

    private static int find(int len, int i) {
        int l = 0, r = len - 1, ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (end[m] >= b[i]) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private static int readInt(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

}
