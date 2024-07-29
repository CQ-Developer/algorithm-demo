package io.huhu.leetcode.classic.other.n6;

import java.util.Scanner;

/**
 * <a href="https://www.luogu.com.cn/problem/P1064">
 * 金明的预算方案
 * </a>
 */
class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] v = new int[m], p = new int[m], q = new int[m];
        for (int i = 0; i < m; i++) {
            v[i] = scanner.nextInt();
            p[i] = scanner.nextInt();
            q[i] = scanner.nextInt();
        }
    }

}
