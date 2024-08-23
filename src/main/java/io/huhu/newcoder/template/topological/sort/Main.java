package io.huhu.newcoder.template.topological.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://www.nowcoder.com/practice/88f7e156ca7d43a1a535f619cd3f495c">
 * Topologic Sort
 * </a>
 */
class Main {

    static final int MAXN = 200001;

    static final int[] QUEUE = new int[MAXN];

    static final int[] INDEGRESS = new int[MAXN];

    static final int[] HEAD = new int[MAXN];
    static final int[] NEXT = new int[MAXN];
    static final int[] TO = new int[MAXN];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        initGraph(n);
        buildGraph(m, scanner);
        int l = 0, r = 0;
        for (int i = 1; i <= n; i++) {
            if (INDEGRESS[i] == 0) {
                QUEUE[r++] = i;
            }
        }
        int i = 0;
        int[] ans = new int[n];
        while (l < r) {
            int f = QUEUE[l++];
            ans[i++] = f;
            for (int j = HEAD[f]; j > 0; j = NEXT[j]) {
                if (--INDEGRESS[TO[j]] == 0) {
                    QUEUE[r++] = TO[j];
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

    static void buildGraph(int m, Scanner scanner) {
        int edge = 1;
        for (int i = 0; i < m; i++) {
            int f = scanner.nextInt(), t = scanner.nextInt();
            NEXT[edge] = HEAD[f];
            TO[edge] = t;
            HEAD[f] = edge++;
            INDEGRESS[t]++;
        }
    }

    static void initGraph(int n) {
        Arrays.fill(HEAD, 0, n + 1, 0);
        Arrays.fill(INDEGRESS, 0, n + 1, 0);
    }

}
