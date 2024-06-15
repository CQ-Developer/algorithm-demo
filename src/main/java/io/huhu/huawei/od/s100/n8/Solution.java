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
        long ch = 0;

        for (int i = 0; i < n; i++) {
            int l = (i - 1 + n) % n;
            int r = (i + 1) % n;
            long num = dfs(pizza, n, l, r, false, pizza[i]);
            ch = Math.max(ch, num);
        }

        System.out.println(ch);
    }

    private static long dfs(int[] pizza, int n, int l, int r, boolean ch, long path) {
        // 最后一块皮萨一定是吃货选
        if (l == r) {
            return table[l][r] = Math.max(table[l][r], path + pizza[l]);
        }
        // 命中曾经走过的路径
        if (table[l][r] != 0) {
            return table[l][r];
        }
        // 馋嘴选最大的
        if (!ch) {
            int max = Math.max(pizza[l], pizza[r]);
            l = pizza[l] == max ? (l - 1 + n) % n : l;
            r = pizza[r] == max ? (r + 1) % n : r;
            return dfs(pizza, n, l, r, true, path);
        }
        // 吃货随意选
        long a = dfs(pizza, n, (l - 1 + n) % n, r, false, path + pizza[l]);
        long b = dfs(pizza, n, l, (r + 1) % n, false, path + pizza[r]);
        return table[l][r] = Math.max(table[l][r], Math.max(a, b));
    }

}
