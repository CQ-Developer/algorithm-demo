package io.huhu.leetcode.n1130;

import io.huhu.AC;

import java.util.Arrays;

@AC
class DepthFirstSearch implements Code {

    @Override
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        // 预处理l..r范围上的最大值
        int[][] max = new int[n][n];
        for (int l = 0; l < n; l++) {
            max[l][l] = arr[l];
            for (int r = l + 1; r < n; r++) {
                max[l][r] = Math.max(max[l][r - 1], arr[r]);
            }
        }
        // memoization
        int[][] dp = new int[n][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        // dfs
        return f(max, dp, 0, n - 1);
    }

    /**
     * f(l,r)表示l...r范围上非叶节点的值的最小可能总和
     */
    private int f(int[][] max, int[][] dp, int l, int r) {
        // l..r范围上只有一个元素, 那么它是叶子节点
        if (l == r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        int ans = Integer.MAX_VALUE;
        // 枚举l...r范围上的所有可能
        for (int i = l; i < r; i++) {
            // f(l,i)表示l...i范围的和, 即左子树的和
            // f(i+1,r)表示i+1...r范围的和, 即右子树的和
            // max[l][i]*max[i+1][r]表示当前非叶节点的值
            ans = Math.min(ans, f(max, dp, l, i) + f(max, dp, i + 1, r) + max[l][i] * max[i + 1][r]);
        }
        return dp[l][r] = ans;
    }

}
