package io.huhu.leetcode.greedy.n1167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://www.luogu.com.cn/problem/P1090">
 * 合并果子
 * </a>
 */
class Luogu {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(System.out)) {
            StreamTokenizer tokenizer = new StreamTokenizer(reader);
            int n = readInt(tokenizer);
            Queue<Integer> heap = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                heap.add(readInt(tokenizer));
            }
            int ans = 0;
            while (heap.size() > 1) {
                int sum = heap.remove() + heap.remove();
                ans += sum;
                heap.add(sum);
            }
            writer.println(ans);
        }
    }

    private static int readInt(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

}
