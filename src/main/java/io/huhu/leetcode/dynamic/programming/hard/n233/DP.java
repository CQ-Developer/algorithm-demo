package io.huhu.leetcode.dynamic.programming.hard.n233;

class DP implements Solution {

    @Override
    public int countDigitOne(int n) {
        int ans = 0;
        for (int num = n, right = 1; num != 0; num /= 10, right *= 10) {
            int left = num / 10, cur = num % 10;
            ans += left * right;
            if (cur > 1) {
                ans += right;
            } else if (cur == 1) {
                ans += (n % right) + 1;
            }
        }
        return ans;
    }

}
