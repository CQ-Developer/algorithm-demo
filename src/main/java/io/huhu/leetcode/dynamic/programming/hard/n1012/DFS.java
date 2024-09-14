package io.huhu.leetcode.dynamic.programming.hard.n1012;

class DFS implements Solution {

    @Override
    public int numDupDigitsAtMostN(int n) {
        return n - f(n);
    }

    private int f(int num) {
        int tmp = num / 10, len = 1, mask = 1;
        while (tmp > 0) {
            tmp /= 10;
            mask *= 10;
            len++;
        }
        int ans = 0;
        if (len >= 2) {
            ans = 9;
            for (int i = 2, p = 9, x = 9; i < len; i++, x--) {
                p *= x;
                ans += p;
            }
        }
        int[] cnt = new int[len];
        cnt[0] = 1;
        for (int i = 1, k = 10 - len + 1; i < len; i++, k++) {
            cnt[i] = cnt[i - 1] * k;
        }
        int first = num / mask;
        ans += (first - 1) * cnt[len - 1];
        return ans + dfs(num, cnt, len - 1, mask / 10, 1 << first);
    }

    private int dfs(int num, int[] cnt, int len, int mask, int status) {
        if (len == 0) {
            return 1;
        }
        int ans = 0, cur = (num / mask) % 10;
        for (int i = 0; i < cur; i++) {
            if ((status & (1 << i)) == 0) {
                ans += cnt[len - 1];
            }
        }
        if ((status & (1 << cur)) == 0) {
            ans += dfs(num, cnt, len - 1, mask / 10, status | (1 << cur));
        }
        return ans;
    }

}
