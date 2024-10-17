package io.huhu.leetcode.greedy.n1167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * <a href="https://www.luogu.com.cn/problem/P1090">
 * 合并果子
 * </a>
 */
class Luogu {

    private static int size;
    private static final int N = 10001;
    private static final int[] heap = new int[N];

    private static void swap(int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    private static void add(int num) {
        int i = size;
        heap[size++] = num;
        while (heap[i] < heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private static int remove() {
        int ans = heap[0];
        swap(0, --size);
        int i = 0, l = 1;
        while (l < size) {
            // 找到i的左右两侧哪个更小
            int j = l + 1 < size && heap[l + 1] < heap[l] ? l + 1 : l;
            // 比较i和j中哪个更小
            j = heap[j] < heap[i] ? j : i;
            if (j == i) {
                break;
            }
            swap(i, j);
            i = j;
            l = i * 2 + 1;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        size = 0;
        try (var reader = new BufferedReader(new InputStreamReader(System.in));
             var writer = new PrintWriter(System.out)) {
            var tokenizer = new StreamTokenizer(reader);
            int n = readInt(tokenizer);
            for (int i = 0; i < n; i++) {
                add(readInt(tokenizer));
            }
            int ans = 0;
            while (size > 1) {
                int sum = remove() + remove();
                ans += sum;
                add(sum);
            }
            writer.println(ans);
        }
    }

    private static int readInt(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

}
