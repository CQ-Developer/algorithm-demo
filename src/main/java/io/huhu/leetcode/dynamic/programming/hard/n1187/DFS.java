package io.huhu.leetcode.dynamic.programming.hard.n1187;

import java.util.Arrays;

class DFS implements Solution {

    @Override
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int m = 1;
        for (int i = 1; i < arr2.length; i++) {
            if (arr2[i] != arr2[m - 1]) {
                arr2[m++] = arr2[i];
            }
        }
        int n = arr1.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = f(arr1, arr2, n, m, 0, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int f(int[] arr1, int[] arr2, int n, int m, int i, int[] dp) {
        if (i == n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        int pre = i == 0 ? Integer.MIN_VALUE : arr1[i - 1];
        int find = find(arr2, m, pre);
        for (int j = i, k = 0; j <= n; j++, k++) {
            if (j == n) {
                ans = Math.min(ans, k);
            } else {
                if (pre < arr1[j]) {
                    int next = f(arr1, arr2, n, m, j + 1, dp);
                    if (next != Integer.MAX_VALUE) {
                        ans = Math.min(ans, next + k);
                    }
                }
                if (find != -1 && find < m) {
                    pre = arr2[find++];
                } else {
                    break;
                }
            }
        }
        return dp[i] = ans;
    }

    private int find(int[] arr, int len, int num) {
        int l = 0, r = len - 1, ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (arr[m] > num) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

}
