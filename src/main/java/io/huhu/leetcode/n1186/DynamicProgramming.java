package io.huhu.leetcode.n1186;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int maximumSum(int[] arr) {
        /*
         * f[i][j]表示前i个结尾的子数组, 删除或不删除数字, 得到的最大结果
         * j=0 表示不能删除数字
         * j=1 表示必须删除数字
         *
         * j = 0
         * f[i][j] = MAX( f[i-1][0], 0 ) + arr[i - 1]
         *
         * j = 1
         * f[i][j] = MAX( f[i-1][0], f[i-1][1] + arr[i-1] )
         */
        int ans = Integer.MIN_VALUE;
        int n = arr.length;
        int[][] f = new int[n + 1][2];
        f[0][0] = f[0][1] = Integer.MIN_VALUE / 2;
        for (int i = 1; i <= n; i++) {
            f[i][0] = Math.max(f[i - 1][0], 0) + arr[i - 1];
            f[i][1] = Math.max(f[i - 1][0], f[i - 1][1] + arr[i - 1]);
            ans = Math.max(ans, Math.max(f[i][0], f[i][1]));
        }
        return ans;
    }

}
