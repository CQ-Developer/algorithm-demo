package io.huhu.leetcode.classic.other.n18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * <a href="https://www.luogu.com.cn/problem/P2657">
 * Windy Number
 * </a>
 */
class Main {

    private static final int MAXN = 11;
    private static final int[][][] DP = new int[MAXN][11][2];

    public static void main(String[] args) throws Exception {
        try (var reader = new BufferedReader(new InputStreamReader(System.in)); var writer = new PrintWriter(System.out)) {
            var tokenizer = new StreamTokenizer(reader);
            int a = readInt(tokenizer), b = readInt(tokenizer);
            int ans = count(b) - count(a - 1);
            writer.println(ans);
        }
    }

    private static int count(int num) {
        if (num == 0) {
            return 1;
        }
        int tmp = num / 10, mask = 1, n = 1;
        while (tmp > 0) {
            tmp /= 10;
            mask *= 10;
            n++;
        }
        for (var a : DP) {
            for (var b : a) {
                b[0] = b[1] = -1;
            }
        }
        return f(num, n, mask, 10, 0);
    }

    private static int f(int num, int n, int mask, int pre, int free) {
        if (n == 0) {
            return 1;
        }
        if (DP[n][pre][free] != -1) {
            return DP[n][pre][free];
        }
        int ans = 0, cur = (num / mask) % 10;
        if (free == 0) {
            if (pre == 10) {
                ans += f(num, n - 1, mask / 10, 10, 1);
                for (int i = 1; i < cur; i++) {
                    ans += f(num, n - 1, mask / 10, i, 1);
                }
                ans += f(num, n - 1, mask / 10, cur, 0);
            } else {
                for (int i = 0; i <= 9; i++) {
                    if (i <= pre - 2 || i >= pre + 2) {
                        if (i < cur) {
                            ans += f(num, n - 1, mask / 10, i, 1);
                        } else if (i == cur) {
                            ans += f(num, n - 1, mask / 10, i, 0);
                        }
                    }
                }
            }
        } else {
            if (pre == 10) {
                ans += f(num, n - 1, mask / 10, 10, 1);
                for (int i = 1; i <= 9; i++) {
                    ans += f(num, n - 1, mask / 10, i, 1);
                }
            } else {
                for (int i = 0; i <= 9; i++) {
                    if (i <= pre - 2 || i >= pre + 2) {
                        ans += f(num, n - 1, mask / 10, i, 1);
                    }
                }
            }
        }
        return DP[n][pre][free] = ans;
    }

    private static int readInt(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

}
