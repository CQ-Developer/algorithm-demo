package io.huhu.huawei.od.s100.n4;

import java.util.Scanner;

class Solution {

    /**
     * input:
     * 0 9 20 -1 -1 15 7 -1 -1 -1 -1 3 2
     * output:
     * 38
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tree = sc.nextLine().split(" ");
        int ans = deliver(tree, 0);
        System.out.println(ans);
    }

    private static int deliver(String[] tree, int p) {
        if (p >= tree.length) {
            return 0;
        }
        int l = (p << 1) + 1, r = (p << 1) + 2;
        int left = l < tree.length ? Integer.parseInt(tree[l]) : 0;
        left = left == -1 ? 0 : left;
        int right = r < tree.length ? Integer.parseInt(tree[r]) : 0;
        right = right == -1 ? 0 : right;
        return Math.max(left, right) + deliver(tree, l) + deliver(tree, r);
    }

}
