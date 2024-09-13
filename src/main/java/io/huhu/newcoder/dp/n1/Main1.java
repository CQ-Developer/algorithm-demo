package io.huhu.newcoder.dp.n1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * 更优的复杂度, 时间复杂度O(n)
 */
class Main1 {

    private static final int N = 100000;
    private static final int[] NUM = new int[N];
    private static final int[] SUM = new int[N];
    private static final int[] END = new int[N];

    private static int n;
    private static int k;

    public static void main(String[] args) throws Exception {
        try (BufferedReader read = new BufferedReader(new InputStreamReader(System.in)); PrintWriter wirter = new PrintWriter(System.out)) {
            StreamTokenizer tokenizer = new StreamTokenizer(read);
            n = readInt(tokenizer);
            k = readInt(tokenizer);
            readNums(tokenizer);
            setup();
            int ans = 0;
            for (int i = 0, sum = 0, j = 0; i < n; i++) {
                while (j < n && sum + SUM[j] <= k) {
                    sum += SUM[j];
                    j = END[j] + 1;
                }
                if (j > i) {
                    ans = Math.max(ans, j - i);
                    sum -= NUM[i];
                } else {
                    j = i + 1;
                }
            }
            wirter.println(ans);
        }
    }

    private static void setup() {
        SUM[n - 1] = NUM[n - 1];
        END[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (SUM[i + 1] < 0) {
                SUM[i] = NUM[i] + SUM[i + 1];
                END[i] = END[i + 1];
            } else {
                SUM[i] = NUM[i];
                END[i] = i;
            }
        }
    }

    private static void readNums(StreamTokenizer tokenizer) throws Exception {
        for (int i = 0; i < n; i++) {
            NUM[i] = readInt(tokenizer);
        }
    }

    private static int readInt(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

}
