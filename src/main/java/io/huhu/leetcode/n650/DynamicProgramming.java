package io.huhu.leetcode.n650;

class DynamicProgramming implements Code {

    /**
     * f(i)表示得到i个A的最少操作次数
     * 假设当前拥有j个A, 由于只能进行全量复制, 所有j必须能被i整除, i % j == 0
     * 复制1次 + 粘贴i/j-1次即可得到i
     * f(i) = Min( f(j) + i / j - 1 + 1 )
     * = Min( f(j) + i / j )
     */
    @Override
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            // 从1个A一个个粘过来
            dp[i] = i;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    /*
                     * i % j = 0
                     * 必然有 j 和 i / j 都是 i 的因数
                     *
                     * 假设 a = j     必然 i % a = 0
                     * 假设 b = i / j 必然 i % b = 0
                     *
                     * 情况a:
                     * f(i) = f(a) + i / a
                     * f(i) = f(j) + i / j
                     *
                     * 情况b:
                     * f(i) = f(b) + i / b
                     * f(i) = f(i / j) + j
                     *
                     * dp[i] = Math.min(dp[i], dp[j] + i / j);
                     * dp[i] = Math.min(dp[i], dp[i / j] + j);
                     */
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }

}
