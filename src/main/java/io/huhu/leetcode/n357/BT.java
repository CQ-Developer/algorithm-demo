package io.huhu.leetcode.n357;

class BT implements Code {

    @Override
    public int countNumbersWithUniqueDigits(int n) {
        return n == 0 ? 1 : f(n, 0, new boolean[10]);
    }

    private int f(int n, int i, boolean[] used) {
        // 所有位置都找了合适的数字
        if (i == n) {
            return 0;
        }
        // 最高位是0
        if (used[0] && i == 1) {
            return 0;
        }
        // 枚举每一种情况
        int ans = 0;
        for (int j = 0; j <= 9; j++) {
            if (used[j]) {
                continue;
            }
            used[j] = true;
            ans += f(n, i + 1, used) + 1;
            used[j] = false;
        }
        return ans;
    }

}
