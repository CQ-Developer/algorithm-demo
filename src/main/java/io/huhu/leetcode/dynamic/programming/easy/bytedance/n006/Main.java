package io.huhu.leetcode.dynamic.programming.easy.bytedance.n006;

import java.util.Scanner;

/**
 * <a href="https://leetcode.cn/problems/tJau2o/">
 * 夏季特惠
 * </a>
 */
class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();
        int[] price = new int[n], discount = new int[n], happy = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
            discount[i] = sc.nextInt();
            happy[i] = sc.nextInt();
        }
        int ans = buy(n, x, price, discount, happy);
        System.err.println(ans);
    }

    static int buy(int n, int x, int[] price, int[] discount, int[] happy) {
        return DFS.buy(n, x, price, discount, happy);
    }

}
