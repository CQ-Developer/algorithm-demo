package io.huhu.leetcode.n837;

class DepthFirstSearch implements Code {

    @Override
    public double new21Game(int n, int k, int maxPts) {
        return f(n, k, maxPts, 0);
    }

    private double f(int n, int k, int p, int c) {
        if (c >= k) {
            return c <= n ? 1 : 0;
        }
        double ans = 0;
        for (int i = 1; i <= p; i++) {
            ans += f(n, k, p, c + i);
        }
        return ans / p;
    }

}
