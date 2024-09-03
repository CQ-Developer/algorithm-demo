package io.huhu.leetcode.dynamic.programming.hard.n465;

/**
 * <a href="https://leetcode.cn/problems/optimal-account-balancing/description/">
 * Optimal Account Balancing
 * </a>
 */
class Solution {

    private static final int N = 13;

    public int minTransfers(int[][] transactions) {
        int[] debt = debts(transactions);
        int n = debt.length;
        return n - f(debt, n, (1 << n) - 1, 0);
    }

    private int f(int[] debt, int n, int status, int sum) {
        int ans = 0;
        if ((status & (status - 1)) != 0) {
            if (sum == 0) {
                for (int i = 0; i < n; i++) {
                    if ((status & (1 << i)) != 0) {
                        ans = f(debt, n, status ^ (1 << i), sum - debt[i]) + 1;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    if ((status & (1 << i)) != 0) {
                        ans = Math.max(ans, f(debt, n, status ^ (1 << i), sum - debt[i]));
                    }
                }
            }
        }
        return ans;
    }

    private int[] debts(int[][] transactions) {
        int[] help = new int[N];
        for (int[] trans : transactions) {
            help[trans[0]] -= trans[2];
            help[trans[1]] += trans[2];
        }
        int n = 0;
        for (int h : help) {
            if (h != 0) {
                n++;
            }
        }
        int i = 0;
        int[] ans = new int[n];
        for (int h : help) {
            if (h != 0) {
                ans[i++] = h;
            }
        }
        return ans;
    }

}
