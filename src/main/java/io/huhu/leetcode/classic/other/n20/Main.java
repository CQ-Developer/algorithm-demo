package io.huhu.leetcode.classic.other.n20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * <a href="https://www.luogu.com.cn/problem/P2602">
 * 数字计数
 * </a>
 */
class Main {

    public static void main(String[] args) throws Exception {
        try (var reader = new BufferedReader(new InputStreamReader(System.in)); var writer = new PrintWriter(System.out)) {
            var tokenizer = new StreamTokenizer(reader);
            long l = readInt(tokenizer), r = readInt(tokenizer);
            for (int i = 0; i < 9; i++) {
                writer.print(f(r, i) - f(l - 1, i) + " ");
            }
            writer.println(f(r, 9) - f(l - 1, 9));
        }
    }

    private static long f(long num, long d) {
        long ans = 0;
        for (long tmp = num, right = 1; tmp != 0; tmp /= 10, right *= 10) {
            long left = tmp / 10, cur = tmp % 10;
            if (d == 0) {
                left--;
            }
            ans += left * right;
            if (cur > d) {
                ans += right;
            } else if (cur == d) {
                ans += (num % right) + 1;
            }
        }
        return ans;
    }

    private static long readInt(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (long) tokenizer.nval;
    }

}
