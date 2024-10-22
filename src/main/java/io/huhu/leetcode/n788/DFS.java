package io.huhu.leetcode.n788;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int rotatedDigits(int n) {
        int len = 1;
        int[] num = new int[6];
        while (n > 0) {
            num[len++] = n % 10;
            n /= 10;
        }
        int[][][] dp = new int[len][2][2];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        // 从高位到低位
        return f(num, len - 1, 1, 0, dp);
    }

    /**
     * 数位DP
     */
    private int f(int[] num, int i, int j, int k, int[][][] dp) {
        if (i == 0) {
            return k;
        }
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        int ans = 0;
        // j == 1
        // 表示前几位数字都相同, 当前不能找找过num[i]的数字, 否则后序结果可能超过num
        for (int _i = 0; _i <= (j == 1 ? num[i] : 9); _i++) {
            // 计算 j 的值
            // 如果 j == 0 表示高位的数字已经小于 num 了, 那么当前位无论怎么选结果都不可能超过 num, 后序也是任意选择
            // 如果 j == 1 表示高位的数字和 num 均相同, 那么当前能选到的最大数字就是 num[i], 当选到 num[i] 时, 后序不能随意选择
            int _bound = j == 1 && _i == num[i] ? 1 : 0;
            // 包含 2 5 6 9 必然是合法的旋转数字, k 设置为 1 表示找到一种结果
            if (_i == 2 || _i == 5 || _i == 6 || _i == 9) {
                ans += f(num, i - 1, _bound, 1, dp);
            }
            // 0 1 8 合法, 但旋转后的数字不能和原数字相同, 所有需要依赖其他的位, k 保持不变
            if (_i == 0 || _i == 1 || _i == 8) {
                ans += f(num, i - 1, _bound, k, dp);
            }
            // 3 4 7 非法, 所以直接不考虑
        }
        return dp[i][j][k] = ans;
    }

}
