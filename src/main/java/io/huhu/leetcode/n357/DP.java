package io.huhu.leetcode.n357;

class DP implements Code {

    @Override
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int ans = 10, accumulator = 9;
        for (int i = 2, mask = 9; i <= n; i++, mask--) {
            accumulator *= mask;
            ans += accumulator;
        }
        return ans;
    }

}
