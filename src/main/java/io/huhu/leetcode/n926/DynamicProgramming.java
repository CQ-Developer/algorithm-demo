package io.huhu.leetcode.n926;

/**
 * TLE
 */
class DynamicProgramming implements Code {

    @Override
    public int minFlipsMonoIncr(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] f = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            /*
             * f[i][0]表示第i个字符为0的翻转次数
             * 前一个字符必须为0, 即翻转次数f[i-1][0]
             *     如果当前字符为0: f[i][0] = f[i-1][0]
             * 前一个字符必须为0, 即翻转次数f[i-1][0]
             *     如果当前字符为1: f[i][0] = f[i-1][0] + 1
             */
            f[i + 1][0] = f[i][0] + (c[i] == '0' ? 0 : 1);
            /*
             * f[i][1]表示第i个字符为1的翻转次数
             * 如果前一个字符是0, 即翻转次数f[i-1][0]
             *     那么不需要翻转, 即f[i][1] = f[i-1][0]
             * 如果前一个字符是1, 即翻转次数f[i-1][1]
             *     且当前字符为1, 那么不需要翻转: f[i][1] = f[i-1][1]
             * 如果前一个字符是1, 即翻转次数f[i-1][1]
             *     且当前字符为0, 那么必须翻转: f[i][1] = f[i-1][1] + 1
             */
            f[i + 1][1] = Math.min(f[i][0], f[i][1] + (c[i] == '0' ? 1 : 0));
        }
        return Math.min(f[n][0], f[n][1]);
    }

}
