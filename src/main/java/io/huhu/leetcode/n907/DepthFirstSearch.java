package io.huhu.leetcode.n907;

class DepthFirstSearch implements Code {

    private static final int M = 1000000007;

    @Override
    public int sumSubarrayMins(int[] arr) {
        return (int) f(arr, 0, arr.length - 1);
    }

    private long f(int[] arr, int l, int r) {
        int i = l;
        for (int j = l; j <= r; j++) {
            if (arr[i] > arr[j]) {
                i = j;
            }
        }
        long ans = (long) arr[i] * (i - l + 1) * (r - i + 1);
        if (l < i) {
            ans = (ans + f(arr, l, i - 1)) % M;
        }
        if (r > i) {
            ans = (ans + f(arr, i + 1, r)) % M;
        }
        return ans;
    }

}
