package io.huhu.leetcode.n96;

class DP implements Code {

    /**
     * g(n)表示长度位n的BST的个数
     * g(0) = g(1) = 0
     * 
     * f(i,n)表示以i为根结点长度为n的BST的个数
     * 
     * g(n) = f(1,n) + f(2,n) + ... + f(n,n)
     * g(n) = ∑(1..n) f(i,n)
     * 
     * f(3,7) = g(2) * g(4)
     * f(i,n) = g(i-1) * g(n-i)
     * 
     * g(n) = ∑(1..n) g(i-1) * g(n-i)
     */
    @Override
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

}
