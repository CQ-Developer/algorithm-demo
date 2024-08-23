package io.huhu.newcoder.template.topological.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://www.nowcoder.com/practice/88f7e156ca7d43a1a535f619cd3f495c">
 * Topologic Sort
 * </a>
 */
class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegress = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int f = scanner.nextInt(), t = scanner.nextInt();
            graph.get(f).add(t);
            indegress[t]++;
        }
        int l = 0, r = 0;
        int[] queue = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (indegress[i] == 0) {
                queue[r++] = i;
            }
        }
        int i = 0;
        int[] ans = new int[n];
        while (l < r) {
            int f = queue[l++];
            ans[i++] = f;
            for (int t : graph.get(f)) {
                if (--indegress[t] == 0) {
                    queue[r++] = t;
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

}
