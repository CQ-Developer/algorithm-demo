package io.huhu.leetcode.classic.other.n13;

import java.util.Arrays;
import java.util.Scanner;

class Main {

    static final int MAXN = 100001;

    static int[] head = new int[MAXN];
    static int[] next = new int[MAXN];
    static int[] to = new int[MAXN];

    static int[] indegress = new int[MAXN];

    static int size;
    static int[] heap = new int[MAXN];

    static int[] ans = new int[MAXN];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        init(n);
        int edge = 1;
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt(), t = sc.nextInt();
            next[f] = head[f];
            to[edge] = t;
            head[f] = edge++;
            indegress[t]++;
        }
        topologicalSort(n);
    }

    static void topologicalSort(int n) {
        for (int i = 1; i <= n; i++) {
            if (indegress[i] == 0) {
                push(i);
            }
        }
        int i = 0;
        while (!isEmpty()) {
            int cur = pop();
            ans[i++] = cur;
            for (int ei = head[cur]; ei > 0; ei = next[ei]) {
                if (--indegress[to[ei]] == 0) {
                    push(to[ei]);
                }
            }
        }
        if (i == n) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(ans[j] + " ");
            }
            System.out.println(ans[n - 1]);
        } else {
            System.out.println(-1);
        }
    }

    static void push(int num) {
        int i = size++;
        heap[i] = num;
        while (heap[i] < heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    static int pop() {
        int num = heap[0];
        heap[0] = heap[--size];
        int i = 0, l = 1;
        while (l < size) {
            int best = l + 1 < size && heap[l + 1] < heap[l] ? l + 1 : l;
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
        return size == 0;
    }

    static void init(int n) {
        size = 0;
        Arrays.fill(indegress, 1, n + 1, 0);
        Arrays.fill(head, 1, n + 1, 0);
    }

}
