package io.huhu.huawei.od.s200.n5;

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        int res = doSolution(s1, s2);
        System.out.println(res);
    }

    public static int doSolution(String s1, String s2) {
        int m = s1.length();
        char[] c1 = new char[m + 1];
        System.arraycopy(s1.toCharArray(), 0, c1, 1, m);
        int n = s2.length();
        char[] c2 = new char[n + 1];
        System.arraycopy(s2.toCharArray(), 0, c2, 1, n);
        return dfs(c1, m, c2, n, 0, 0, 0);
    }

    private static int dfs(char[] s1, int m, char[] s2, int n, int i, int j, int path) {
        if (i == m && j == n) {
            return path;
        }
        // 斜下方的字母相等
        if (i < m && j < n && s1[i + 1] == s2[j + 1]) {
            return dfs(s1, m, s2, n, i + 1, j + 1, path + 1);
        }
        // 到达右边界只能向下走
        if (i < m && j == n) {
            return path + m - i;
        }
        // 到当下边界只能向右走
        if (i == m && j < n) {
            return path + n - j;
        }
        // 可以向右或者向下走
        int a = dfs(s1, m, s2, n, i + 1, j, path + 1);
        int b = dfs(s1, m, s2, n, i, j + 1, path + 1);
        return Math.min(a, b);
    }

}
