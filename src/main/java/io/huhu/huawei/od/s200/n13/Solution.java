package io.huhu.huawei.od.s200.n13;

import java.util.Scanner;

/**
 * <a href="https://blog.csdn.net/shangyanaf/article/details/135139326">找最小数</a>
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // input
        StringBuilder num = new StringBuilder(scanner.next());
        int n = scanner.nextInt();
        // alg
        int result = dfs(num, n);
        // output
        System.out.println(result);
    }

    private static int dfs(StringBuilder num, int n) {
        if (n == 0) {
            return Integer.parseInt(num.toString());
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int min = dfs(num.deleteCharAt(i), n - 1);
            num.insert(i, c);
            result = Math.min(min, result);
        }
        return result;
    }

}
