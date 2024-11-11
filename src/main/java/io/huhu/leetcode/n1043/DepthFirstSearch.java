package io.huhu.leetcode.n1043;

class DepthFirstSearch implements Code {

    @Override
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return f(arr, k, arr.length - 1);
    }

    private int f(int[] arr, int k, int i) {
        int ans = 0, max = 0;
        for (int j = i; j >= 0 && i - j + 1 <= k; j--) {
            max = Math.max(max, arr[j]);
            ans = Math.max(ans, max * (i - j + 1) + f(arr, k, j - 1));
        }
        return ans;
    }

}
