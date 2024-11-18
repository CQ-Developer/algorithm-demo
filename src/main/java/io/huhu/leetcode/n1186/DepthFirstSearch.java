package io.huhu.leetcode.n1186;

import io.huhu.TLE;

@TLE
class DepthFirstSearch implements Code {

    @Override
    public int maximumSum(int[] arr) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, Math.max(f(arr, i, 0), f(arr, i, 1)));
        }
        return ans;
    }

    /**
     * f(i,j)表示以i作为右端点的子数组, 删除或不删除数字时, 子数组的最大和
     * j=0 表示不能删除数字
     * j=1 表示必须删除数字
     */
    private int f(int[] arr, int i, int j) {
        if (i < 0) {
            return Integer.MIN_VALUE / 2;
        }
        if (j == 0) {
            // arr[i]自己构成子数组
            // 考虑i左侧数字构成子数组
            return Math.max(f(arr, i - 1, 0), 0) + arr[i];
        }
        // 删除i构成的子数组
        // 不删除i构成的子数组
        return Math.max(f(arr, i - 1, 1) + arr[i], f(arr, i - 1, 0));
    }

}
