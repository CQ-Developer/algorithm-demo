package io.huhu.leetcode.classic.other.n6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.luogu.com.cn/problem/P1064">
 * 金明的预算方案
 * </a>
 */
class DFS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] v = new int[m + 1], p = new int[m + 1], fan = new int[m + 1];
        boolean[] main = new boolean[m + 1];
        int[][] follower = new int[m + 1][2];
        for (int i = 1; i <= m; i++) {
            v[i] = scanner.nextInt();
            p[i] = scanner.nextInt();
            int q = scanner.nextInt();
            p[i] *= v[i];
            main[i] = q == 0;
            if (!main[i]) {
                follower[q][fan[q]++] = i;
            }
        }
        int ans = dfs(n, v, p, main, fan, follower, 0, 0, new HashMap<>());
        System.out.println(ans);
    }

    /**
     * TLE
     */
    private static int dfs(int budget, int[] price, int[] value, boolean[] primary, int[] size, int[][] id, int i, int x, Map<Integer, Map<Integer, Map<Integer, Integer>>> m) {
        if (budget < 0) {
            return 0;
        }
        if (i == price.length) {
            return x;
        }
        if (m.containsKey(i) && m.get(i).containsKey(budget) && m.get(i).get(budget).containsKey(x)) {
            return m.get(i).get(budget).get(x);
        }
        if (!primary[i]) {
            return dfs(budget, price, value, primary, size, id, i + 1, x, m);
        }
        int a = dfs(budget - price[i], price, value, primary, size, id, i + 1, x + value[i], m);
        if (size[i] == 1) {
            int c = dfs(budget - price[i] - price[id[i][0]], price, value, primary, size, id, i + 1, x + value[i] + value[id[i][0]], m);
            a = Integer.max(a, c);
        }
        if (size[i] == 2) {
            int c = dfs(budget - price[i] - price[id[i][0]], price, value, primary, size, id, i + 1, x + value[i] + value[id[i][0]], m);
            a = Integer.max(a, c);
            int d = dfs(budget - price[i] - price[id[i][1]], price, value, primary, size, id, i + 1, x + value[i] + value[id[i][1]], m);
            a = Integer.max(a, d);
            int e = dfs(budget - price[i] - price[id[i][0]] - price[id[i][1]], price, value, primary, size, id, i + 1, x + value[i] + value[id[i][0]] + value[id[i][1]], m);
            a = Integer.max(a, e);
        }
        int b = dfs(budget, price, value, primary, size, id, i + 1, x, m);
        int ans = Integer.max(a, b);
        m.putIfAbsent(i, new HashMap<>());
        Map<Integer, Map<Integer, Integer>> map = m.get(i);
        map.putIfAbsent(budget, new HashMap<>());
        map.get(budget).put(x, ans);
        return ans;
    }

}
