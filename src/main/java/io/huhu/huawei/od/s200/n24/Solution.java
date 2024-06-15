package io.huhu.huawei.od.s200.n24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 电脑病毒感染
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        boolean[] infection = new boolean[n + 1];

        int m = scanner.nextInt();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[][] table = new int[m][];
        for (int i = 0; i < m; i++) {
            int f = scanner.nextInt(), t = scanner.nextInt(), w = scanner.nextInt();
            int[] arr = {f, t, w};
            table[i] = arr;
            List<Integer> list = graph.getOrDefault(f, new ArrayList<>());
            list.addLast(t);
            graph.put(f, list);
        }

        int start = scanner.nextInt();

        // init
        List<Integer> queue = new ArrayList<>();
        queue.addLast(start);

        int ans = 0;

        // bfs
        while (!queue.isEmpty()) {
            int i = queue.removeFirst();
            if (infection[i]) {
                continue;
            }
            infection[i] = true;
            List<Integer> list = graph.get(i);
            if (list == null || list.isEmpty()) {
                continue;
            }
            int max = Integer.MIN_VALUE;
            for (int j : list) {
                for (int[] weight : table) {
                    if (weight[0] == i && weight[1] == j) {
                        max = Math.max(max, weight[2]);
                        break;
                    }
                }
                queue.addLast(j);
            }
            ans += max;
        }

        // result
        for (int i = 1; i < infection.length; i++) {
            if (!infection[i]) {
                ans = -1;
                break;
            }
        }
        System.out.println(ans);
    }

}
