package io.huhu.leetcode.binary.search.hard.n2141;

final class Greedy implements Solution {

    @Override
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        int max = 0;
        for (int battery : batteries) {
            sum += battery;
            max = Integer.max(max, battery);
        }
        if (sum > (long) max * n) {
            return sum / n;
        }
        int l = 0, r = max, ans = 0;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (f(batteries, n, m)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    private boolean f(int[] batteries, int n, int m) {
        long sum = 0;
        for (int battery : batteries) {
            if (battery > m) {
                n--;
            } else {
                sum += battery;
            }
            if (sum >= (long) n * m) {
                return true;
            }
        }
        return false;
    }

}
