package io.huhu.leetcode.classic.other.n7;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * <a href="https://www.luogu.com.cn/problem/P1757">
 * 分组背包
 * </a>
 */
class DFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weight = sc.nextInt(), n = sc.nextInt();
        int[] w = new int[n], v = new int[n], g = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
            g[i] = sc.nextInt();
        }
        int ans = dfs(weight, w, v, g, n, 0, new HashSet<>());
        System.out.println(ans);
    }

    private static int dfs(int r, int[] w, int[] v, int[] g, int n, int i, Set<Integer> set) {
        if (i == n) {
            return 0;
        }
        int ans = dfs(r, w, v, g, n, i + 1, set);
        if (!set.contains(g[i]) && r - w[i] >= 0) {
            set.add(g[i]);
            ans = Integer.max(ans, dfs(r - w[i], w, v, g, n, i + 1, set) + v[i]);
            set.remove(g[i]);
        }
        return ans;
    }

}
