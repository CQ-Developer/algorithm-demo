package io.huhu.leetcode.n788;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int rotatedDigits(int n) {
        int _n = n / 10, len = 1, mask = 1;
        while (_n > 0) {
            _n /= 10;
            mask *= 10;
            len++;
        }
        int[][][] m = new int[len + 1][2][2];
        for (int[][] a : m) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return f(n, mask, len, 0, 0, m);
    }

    /**
     * 数位 DP
     *
     * @param free 0表示不可以自由选择, 1表示可以自由选择
     * @param used 0表示之前没有使用过数字, 1表示之前使用过数字
     */
    private int f(int n, int mask, int len, int free, int used, int[][][] m) {
        if (len == 0) {
            return used;
        }
        if (m[len][free][used] != -1) {
            return m[len][free][used];
        }
        int ans = 0;
        if (free == 1) {
            ans += 4 * f(n, mask / 10, len - 1, 1, 1, m);
            ans += 3 * f(n, mask / 10, len - 1, 1, used, m);
        } else {
            int num = (n / mask) % 10;
            for (int i = 0; i <= num; i++) {
                int _free = i == num ? 0 : 1;
                if (i == 2 || i == 5 || i == 6 || i == 9) {
                    ans += f(n, mask / 10, len - 1, _free, 1, m);
                }
                if (i == 0 || i == 1 || i == 8) {
                    ans += f(n, mask / 10, len - 1, _free, used, m);
                }
            }
        }
        return m[len][free][used] = ans;
    }

}
