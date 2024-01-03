package io.huhu.leetcode.bit.manipulation.easy.n338;

/**
 * <a href="https://leetcode.cn/problems/counting-bits/description/">比特位计算</a>
 */
class Solution {

    /**
     * <p>方法一: API</p>
     * <pre>{@code
     * public int[] countBits(int n) {
     *     int[] res = new int[n + 1];
     *     for (int i = 0; i <= n; i++) {
     *         res[i] = Integer.bitCount(i);
     *     }
     *     return res;
     * }
     * }</pre>
     * <p>方法二: 与运算</p>
     * <p>n & (n - 1) 可以将 n 的最后一位 1 变为 0</p>
     * <p>例如 15(1111) 进行如下计算:</p>
     * <pre>
     * 第1步:
     * 15 & 14 =   1111
     *           & 1110
     *           = 1110 = 14
     * 第2步:
     * 14 & 13 =   1110
     *           & 1101
     *           = 1100 = 12
     * 第3步:
     * 12 & 11 =   1100
     *           & 1011
     *           = 1000 = 8
     * 第4步:
     * 8 & 7 =   1000
     *         & 0111
     *         = 0000 = 0
     * </pre>
     * <pre>{@code
     * public int[] countBits(int n) {
     *     int[] res = new int[n + 1];
     *     for (int i = 0; i <= n; i++) {
     *         res[i] = count(i);
     *     }
     *     return res;
     * }
     *
     * private int count(int n) {
     *     int cnt = 0;
     *     while (n != 0) {
     *         n &= (n - 1);
     *         cnt++;
     *     }
     *     return cnt;
     * }
     * }</pre>
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

}
