package io.huhu.leetcode.n1191;

import io.huhu.AC;

@AC
class Solution2 implements Code {

    private static final int M = 1000000007;

    @Override
    public int kConcatenationMaxSum(int[] arr, int k) {
        long sum = 0;
        for (int num : arr) {
            sum += num;
        }
        int n = arr.length, _n = n;
        if (k >= 2) {
            _n <<= 1;
        }
        long pre = arr[0], max = Math.max(pre, 0);
        for (int i = 1; i < _n; i++) {
            pre = Math.max(pre + arr[i % n], arr[i % n]);
            max = Math.max(max, pre);
        }
        if (k <= 2) {
            return (int) (max % M);
        }
        return (int) ((Math.max(sum, 0) * (k - 2) + max) % M);
    }

}
