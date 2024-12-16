package io.huhu.leetcode.n2222;

class DynamicProgramming implements Solution {

    /**
     * 2种状态: 101, 010
     */
    @Override
    public long numberOfWays(String s) {
        char[] c = s.toCharArray();
        // total0表示0字符的总量
        int total0 = 0;
        for (char _c : c) {
            if (_c == '0') {
                total0++;
            }
        }
        long res = 0;
        // left0表示i左侧0字符的数量
        int n = c.length, left0 = 0;
        for (int i = 0; i < n; i++) {
            // 010: 左侧0的数量 * 右侧0的数量
            if (c[i] == '1') {
                res += (long) left0 * (total0 - left0);
            }
            // 101: 左侧1的数量 * 右侧1的数量
            else {
                left0++;
                int left1 = i + 1 - left0;
                res += (long) left1 * (n - total0 - left1);
            }
        }
        return res;
    }

}
