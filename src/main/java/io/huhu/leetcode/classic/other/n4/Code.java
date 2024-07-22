package io.huhu.leetcode.classic.other.n4;

import java.util.Scanner;

/**
 * <a href="https://www.luogu.com.cn/problem/P8776">
 * 最长不下降子序列
 * </a>
 */
class Code {

    static final int MAXN = 100001;

    static int n, k;
    static final int[] ARR = new int[MAXN], ENDS = new int[MAXN], RIGHT = new int[MAXN];

    public static void main(String[] args) {
        // 5 1
        // 1 4 2 8 5
        // 4
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            ARR[i] = sc.nextInt();
        }
        int ans = compute();
        System.out.println(ans);
    }

    private static int compute() {
        right();
        int len = 0, ans = 0;
        for (int i = 0, j = k; j < n; i++, j++) {
            int find = bs2(len, ARR[j]);
            int left = find == -1 ? len : find;
            ans = Integer.max(ans, left + k + RIGHT[j]);
            find = bs2(len, ARR[i]);
            if (find == -1) {
                ENDS[len++] = ARR[i];
            } else {
                ENDS[find] = ARR[i];
            }
        }
        return ans;
    }

    private static void right() {
        int len = 0;
        for (int i = n - 1; i >= 0; i--) {
            int find = bs1(len, ARR[i]);
            if (find == -1) {
                ENDS[len++] = ARR[i];
                RIGHT[i] = len;
            } else {
                ENDS[find] = ARR[i];
                RIGHT[i] = find + 1;
            }
        }
    }

    private static int bs1(int len, int num) {
        int l = 0, r = len - 1, ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (ENDS[m] < num) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private static int bs2(int len, int num) {
        int l = 0, r = len - 1, ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (ENDS[m] > num) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

}
