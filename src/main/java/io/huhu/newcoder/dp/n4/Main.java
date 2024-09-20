package io.huhu.newcoder.dp.n4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * <a href="https://www.nowcoder.com/practice/736e12861f9746ab8ae064d4aae2d5a9">
 * 打怪兽
 * </a>
 */
class Main {

    private static final int N = 500;

    private static int[] power = new int[N + 1];
    private static int[] money = new int[N + 1];

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StreamTokenizer tokenizer = new StreamTokenizer(reader);
            int n = readInt(tokenizer), m = 0;
            for (int i = 1; i <= n; i++) {
                m += (power[i] = readInt(tokenizer));
                money[i] = readInt(tokenizer);
            }
            int[] dp = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                dp[j] = Integer.MAX_VALUE;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = m; j >= 0; j--) {
                    int t = Integer.MAX_VALUE;
                    if (j >= power[i] && dp[j] != Integer.MAX_VALUE) {
                        t = dp[j];
                    }
                    if (j >= power[i] && dp[j - power[i]] != Integer.MAX_VALUE) {
                        t = Math.min(t, dp[j - power[i]] + money[i]);
                    }
                    dp[j] = t;
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j <= m; j++) {
                ans = Math.min(ans, dp[j]);
            }
            try (PrintWriter writer = new PrintWriter(System.out)) {
                writer.println(ans == Integer.MAX_VALUE ? -1 : ans);
            }
        }
    }

    private static int readInt(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

}
