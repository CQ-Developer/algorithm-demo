package io.huhu.leetcode.dynamic.programming.hard.n1187;

import java.util.Arrays;

class DP implements Solution {

    @Override
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int n = arr1.length, m = sortAndCount(arr2);
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int ans = Integer.MAX_VALUE;
            int pre = i == 0 ? Integer.MIN_VALUE : arr1[i - 1];
            int find = find(arr2, m, pre);
            for (int j = i, k = 0; j <= n; j++, k++) {
                if (j == n) {
                    ans = Math.min(ans, k);
                } else {
                    if (pre < arr1[j]) {
                        int next = dp[j + 1];
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
            dp[i] = ans;
        }
        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }

    private int find(int[] arr, int n, int num) {
        int ans = -1;
        int l = 0, r = n - 1;
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

    private int sortAndCount(int[] arr) {
        Arrays.sort(arr);
        int n = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[n - 1]) {
                arr[n++] = arr[i];
            }
        }
        return n;
    }

}
