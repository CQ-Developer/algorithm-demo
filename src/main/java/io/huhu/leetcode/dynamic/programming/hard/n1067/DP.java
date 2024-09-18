package io.huhu.leetcode.dynamic.programming.hard.n1067;

class DP implements Solution {

    @Override
    public int digitsCount(int d, int low, int high) {
        return f(high, d) - f(low - 1, d);
    }

    private int f(int num, int d) {
        int ans = 0;
        for (int digit = num, right = 1; digit != 0; digit /= 10, right *= 10) {
            int left = digit / 10;
            int cur = digit % 10;
            if (d == 0) {
                left--;
            }
            ans += left * right;
            if (cur > d) {
                ans += right;
            } else if (cur == d) {
                ans += (num % right) + 1;
            }
        }
        return ans;
    }

}
