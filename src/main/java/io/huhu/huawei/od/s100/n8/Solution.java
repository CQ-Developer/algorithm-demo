package io.huhu.huawei.od.s100.n8;

import java.util.Scanner;

/**
 * 分皮萨
 */
class Solution {

    static long[][] table;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] pizza = new int[n];
        for (int i = 0; i < n; i++) {
            pizza[i] = scanner.nextInt();
        }

        table = new long[n][n];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int l = (i - 1 + n) % n;
            int r = (i + 1) % n;
            ans = Math.max(ans, pizza[i] + dfs(pizza, n, n - 1, l, r));
        }

        System.out.println(ans);
    }

    private static long dfs(int[] pizza, int n, int k, int l, int r) {
        if (k <= 0) {
            return 0;
        }
        if (pizza[l] > pizza[r]) {
            l = (l - 1 + n) % n;
        } else {
            r = (r + 1) % n;
        }
        if (table[l][r] != 0) {
            return table[l][r];
        }
        long a = pizza[l] + dfs(pizza, n, k - 2, (l - 1 + n) % n, r);
        long b = pizza[r] + dfs(pizza, n, k - 2, l, (r + 1) % n);
        return table[l][r] = Math.max(a, b);
    }

}
