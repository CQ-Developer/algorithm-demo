package io.huhu.newcoder.dp.n1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * <a href="https://www.nowcoder.com/practice/3473e545d6924077a4f7cbc850408ade">
 * 未排序数组中累加和小于或等于给定值的最长子数组长度
 * </a>
 */
class Main {

    private static final int N = 100000;
    private static final int[] ARR = new int[N];

    private static int n;
    private static int k;

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); PrintWriter writer = new PrintWriter(System.out)) {
            StreamTokenizer tokenizer = new StreamTokenizer(reader);
            n = read(tokenizer);
            k = read(tokenizer);
            readNums(tokenizer);
            int[] sums = preSums();
            int ans = 0;
            for (int i = 0, sum = 0; i < n; i++) {
                sum += ARR[i];
                int pre = find(sums, sum - k);
                int len = pre == -1 ? 0 : i - pre + 1;
                ans = Math.max(ans, len);
            }
            writer.println(ans);
        }
    }

    private static int find(int[] sums, int num) {
        int l = 0, r = n, find = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (sums[m] >= num) {
                find = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return find;
    }

    private static int[] preSums() {
        int sum = 0;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum += ARR[i];
            sums[i + 1] = Math.max(sum, sums[i]);
        }
        return sums;
    }

    private static void readNums(StreamTokenizer tokenizer) throws Exception {
        for (int i = 0; i < n; i++) {
            ARR[i] = read(tokenizer);
        }
    }

    private static int read(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

}
