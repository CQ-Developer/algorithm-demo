package io.huhu.leetcode.classic.other.n19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * <a href="https://www.luogu.com.cn/problem/P3413">
 * 萌数
 * </a>
 */
class Main {

    private static final int M = (int) 1E9 + 7;
    private static final int MAXN = 1001;
    private static final int[][][][] DP = new int[MAXN][11][11][2];

    public static void main(String[] args) throws Exception {
        try (var reader = new BufferedReader(new InputStreamReader(System.in)); var writer = new PrintWriter(System.out)) {
            String[] range = reader.readLine().split(" ");
            int ans = compute(range[0].toCharArray(), range[1].toCharArray());
            writer.println(ans);
        }
    }

    private static int compute(char[] l, char[] r) {
        int ans = (count(r) - count(l) + M) % M;
        if (check(l)) {
            ans = (ans + 1) % M;
        }
        return ans;
    }

    private static int count(char[] num) {
        if (num[0] == '0') {
            return 0;
        }
        int n = num.length;
        long all = 0, mask = 1;
        for (int i = n - 1; i >= 0; i--) {
            all = (all + (num[i] - '0') * mask) % M;
            mask = (10 * mask) % M;
        }
        init(n);
        return (int) ((all - f(num, 0, 10, 10, 0) + M) % M);
    }

    private static int f(char[] num, int i, int pp, int p, int free) {
        if (i == num.length) {
            return 1;
        }
        if (DP[i][pp][p][free] != -1) {
            return DP[i][pp][p][free];
        }
        int ans = 0;
        if (free == 0) {
            if (p == 10) {
                ans = (ans + f(num, i + 1, p, 10, 1)) % M;
                for (int cur = 1; cur < num[i] - '0'; cur++) {
                    ans = (ans + f(num, i + 1, p, cur, 1)) % M;
                }
                ans = (ans + f(num, i + 1, p, num[i] - '0', 0)) % M;
            } else {
                for (int cur = 0; cur < num[i] - '0'; cur++) {
                    if (cur != pp && cur != p) {
                        ans = (ans + f(num, i + 1, p, cur, 1)) % M;
                    }
                }
                if (num[i] - '0' != pp && num[i] - '0' != p) {
                    ans = (ans + f(num, i + 1, p, num[i] - '0', 0)) % M;
                }
            }
        } else {
            if (p == 10) {
                ans = (ans + f(num, i + 1, p, 10, 1)) % M;
                for (int cur = 1; cur <= 9; cur++) {
                    ans = (ans + f(num, i + 1, p, cur, 1)) % M;
                }
            } else {
                for (int cur = 0; cur <= 9; cur++) {
                    if (cur != pp && cur != p) {
                        ans = (ans + f(num, i + 1, p, cur, 1)) % M;
                    }
                }
            }
        }
        return DP[i][pp][p][free] = ans;
    }

    private static boolean check(char[] num) {
        for (int pp = -2, p = -1, i = 0; i < num.length; pp++, p++, i++) {
            if (pp >= 0 && num[pp] == num[i]) {
                return true;
            }
            if (p >= 0 && num[p] == num[i]) {
                return true;
            }
        }
        return false;
    }

    private static void init(int n) {
        for (int a = 0; a < n; a++) {
            for (int b = 0; b <= 10; b++) {
                for (int c = 0; c <= 10; c++) {
                    DP[a][b][c][0] = -1;
                    DP[a][b][c][1] = -1;
                }
            }
        }
    }

}
