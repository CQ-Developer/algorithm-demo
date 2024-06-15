package io.huhu.huawei.od.s100.n8;

import java.util.Scanner;

/**
 * 分皮萨
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] pizza = new int[n];
        for (int i = 0; i < n; i++) {
            pizza[i] = scanner.nextInt();
        }

        long ch = 0;

        for (int i = 0; i < n; i++) {
            int l = (i - 1 + n) % n;
            int r = (i + 1) % n;
            long num = dfs(pizza, n, l, r, n - 1, false, pizza[i]);
            ch = Math.max(ch, num);
        }

        System.out.println(ch);
    }

    private static long dfs(int[] pizza, int n, int l, int r, int rest, boolean ch, long path) {
        if (rest == 0) {
            return path;
        }
        // 馋嘴选最大的
        if (!ch) {
            int max = Math.max(pizza[l], pizza[r]);
            l = pizza[l] == max ? (l - 1 + n) % n : l;
            r = pizza[r] == max ? (r + 1) % n : r;
            return dfs(pizza, n, l, r, rest - 1, true, path);
        }
        // 吃货随意选
        long a = dfs(pizza, n, (l - 1 + n) % n, r, rest - 1, false, path + pizza[l]);
        long b = dfs(pizza, n, l, (r + 1) % n, rest - 1, false, path + pizza[r]);
        return Math.max(a, b);
    }

}
