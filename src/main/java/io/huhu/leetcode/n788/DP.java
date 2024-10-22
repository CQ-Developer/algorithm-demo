package io.huhu.leetcode.n788;

class DP implements Code {

    @Override
    public int rotatedDigits(int n) {
        int ans = 0;
        /*
         * f[i] == 0 : 无效数字 3 4 7
         * f[i] == 1 : 有效数字 0 1 8
         * f[i] == 2 : 有效数字 2 5 6 9
         */
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int high = i / 10, low = i % 10;
            if (low != 3 && low != 4 && low != 7) {
                if (low == 2 || low == 5 || low == 6 || low == 9) {
                    f[i] = f[high] == 0 ? 0 : 2;
                } else {
                    f[i] = f[high];
                }
                ans += f[i] == 2 ? 1 : 0;
            }
        }
        return ans;
    }

}
