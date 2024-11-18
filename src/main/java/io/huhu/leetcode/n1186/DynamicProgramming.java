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
        int ans = Integer.MIN_VALUE / 2;
        int p0 = ans, p1 = ans;
        for (int num : arr) {
            int _p0 = Math.max(p0, 0) + num;
            p1 = Math.max(p0, p1 + num);
            p0 = _p0;
            ans = Math.max(ans, Math.max(p0, p1));
        }
        return ans;
    }

}
