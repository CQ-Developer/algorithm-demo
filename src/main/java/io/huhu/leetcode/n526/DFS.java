package io.huhu.leetcode.n526;

class DFS implements Code {

    @Override
    public int countArrangement(int n) {
        return f(1, 0, n);
    }

    private int f(int i, int s, int n) {
        if (i == n + 1) {
            return 1;
        }
        int ans = 0;
        for (int num = 1; num <= n; num++) {
            if (((1 << num) & s) == 0 && (i % num == 0 || num % i == 0)) {
                ans += f(i + 1, (1 << num) | s, n);
            }
        }
        return ans;
    }

}
