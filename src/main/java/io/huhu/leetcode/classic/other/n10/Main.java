package io.huhu.leetcode.classic.other.n10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://www.luogu.com.cn/problem/P1833">樱花</a>
 */
class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t1 = sc.next(), t2 = sc.next();
        int t = toMin(t2) - toMin(t1), n = sc.nextInt();
        List<Integer> costs = new ArrayList<>(), values = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int c = sc.nextInt(), v = sc.nextInt(), cnt = sc.nextInt();
            for (int j = 1; j <= cnt; j <<= 1) {
                costs.add(j * c);
                values.add(j * v);
                cnt -= j;
            }
            if (cnt > 0) {
                costs.add(cnt * c);
                values.add(cnt * v);
            }
        }
        int[] dp = new int[t + 1];
        for (int i = 0; i < values.size(); i++) {
            for (int j = t; j >= costs.get(i); j--) {
                dp[j] = Integer.max(dp[j], dp[j - costs.get(i)] + values.get(i));
            }
        }
        System.out.println(dp[t]);
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
