package io.huhu.huawei.od.s200.n4;

import java.util.Scanner;

/**
 * wonderland
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] items = s.split(" ");
        int[] costs = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            costs[i] = Integer.parseInt(items[i]);
        }
        s = scanner.nextLine();
        items = s.split(" ");
        int[] days = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            days[i] = Integer.parseInt(items[i]);
        }
        int ans = doSolution(costs, days);
        System.out.println(ans);
    }

    public static int doSolution(int[] costs, int[] days) {
        int[] dp = new int[days[days.length - 1] + 1];
        for (int i = 1, j = 0; i < dp.length; i++) {
            if (i == days[j]) {
                int d1 = dp[i - 1] + costs[0];
                int d3 = i >= 3 ? dp[i - 3] + costs[1] : costs[1];
                int d7 = i >= 7 ? dp[i - 7] + costs[2] : costs[2];
                int d30 = i >= 30 ? dp[i - 30] + costs[3] : costs[3];
                dp[i] = Math.min(d1, Math.min(d3, Math.min(d7, d30)));
                j++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

}
