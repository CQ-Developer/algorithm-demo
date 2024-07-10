package io.huhu.leetcode.binary.search.hard.n2141;

final class BinarySearch implements Solution {

    @Override
    public long maxRunTime(int n, int[] batteries) {
        long l = 0, r = 0;
        for (int b : batteries) {
            r += b;
        }
        long ans = 0;
        while (l <= r) {
            long m = l + ((r - l) >> 1);
            if (f(batteries, n, m)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    private boolean f(int[] batteries, int n, long m) {
        long sum = 0;
        for (int b : batteries) {
            if (b > m) {
                n--;
            } else {
                sum += b;
            }
            if (sum >= n * m) {
                return true;
            }
        }
        return false;
    }

}
