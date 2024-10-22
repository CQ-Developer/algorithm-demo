package io.huhu.leetcode.n788;

class Exhaustion implements Code {

    private static final int[] TABLE = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};

    @Override
    public int rotatedDigits(int n) {
        int ans = 0;
        for (int num = 1; num <= n; num++) {
            if (check1(num)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean check1(int num) {
        int ans = 0, factor = 1;
        int _num = num;
        while (_num > 0) {
            int i = _num % 10;
            _num /= 10;
            if (TABLE[i] == -1) {
                return false;
            }
            ans = TABLE[i] * factor + ans;
            factor *= 10;
        }
        return ans != num;
    }

}
