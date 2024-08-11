package io.huhu.leetcode.classic.other.n11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://www.nowcoder.com/practice/e391767d80d942d29e6095a935a5b96b">
 * 括号区间匹配
 * </a>
 */
class DFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] f = new int[n][n];
        for (int[] a : f) {
            Arrays.fill(a, -1);
        }
        int ans = dfs(c, 0, n - 1, f);
        System.out.println(ans);
    }

    private static int dfs(char[] s, int l, int r, int[][] f) {
        if (l == r) {
            return 1;
        }
        if (l + 1 == r) {
            if ((s[l] == '(' && s[r] == ')') || (s[l] == '[' && s[r] == ']')) {
                return 0;
            }
            return 2;
        }
        if (f[l][r] != -1) {
            return f[l][r];
        }
        int p1 = Integer.MAX_VALUE;
        if ((s[l] == '(' && s[r] == ')') || (s[l] == '[' && s[r] == ']')) {
            p1 = dfs(s, l + 1, r - 1, f);
        }
        int p2 = Integer.MAX_VALUE;
        for (int i = l; i < r; i++) {
            p2 = Integer.min(p2, dfs(s, l, i, f) + dfs(s, i + 1, r, f));
        }
        return f[l][r] = Integer.min(p1, p2);
    }

}
