package io.huhu.leetcode.n1191;

import io.huhu.AC;

import java.util.Arrays;

/**
 * dynamic programming
 */
@AC
class Solution1 implements Code {

    private static final int M = 1000000007;

    @Override
    public int kConcatenationMaxSum(int[] arr, int k) {
        long sum = 0;
        for (int num : arr) {
            sum += num;
        }
        int n = arr.length;
        if (k >= 2) {
            arr = Arrays.copyOf(arr, n << 1);
            System.arraycopy(arr, 0, arr, n, n);
            n <<= 1;
        }
        long pre = arr[0], max = Math.max(pre, 0);
        for (int i = 1; i < n; i++) {
            pre = Math.max(pre + arr[i], arr[i]);
            max = Math.max(max, pre);
        }
        if (k <= 2) {
            return (int) (max % M);
        }
        return (int) ((Math.max(sum, 0) * (k - 2) + max) % M);
    }

}
