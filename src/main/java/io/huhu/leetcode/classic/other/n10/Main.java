package io.huhu.leetcode.classic.other.n10;

import java.util.Scanner;

/**
 * <a href="https://www.luogu.com.cn/problem/P1833">樱花</a>
 */
class Main {

    static final int[] C = new int[100001];
    static final int[] V = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t1 = sc.next(), t2 = sc.next();
        int time = toMin(t2) - toMin(t1), n = sc.nextInt(), m = 0;
        for (int i = 1; i <= n; i++) {
            int c = sc.nextInt(), v = sc.nextInt(), k = sc.nextInt();
            if (k == 0) {
                k = 1000;
            }
            for (int b = 1; b <= k; b <<= 1) {
                C[++m] = c * b;
                V[m] = v * b;
                k -= b;
            }
            if (k > 0) {
                C[++m] = c * k;
                V[m] = v * k;
            }
        }
        int[] dp = new int[time + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = time; j >= C[i]; j--) {
                dp[j] = Integer.max(dp[j], dp[j - C[i]] + V[i]);
            }
        }
        System.out.println(dp[time]);
    }

    private static int toMin(String s) {
        int ans = 0, t = 0;
        for (char c : s.toCharArray()) {
            if (c == ':') {
                ans += t * 60;
                t = 0;
            } else {
                t = (c - '0') + 10 * t;
            }
        }
        return ans + t;
    }

}
