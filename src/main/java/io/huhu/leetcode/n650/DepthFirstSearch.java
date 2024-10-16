package io.huhu.leetcode.n650;

class DepthFirstSearch implements Code {

    @Override
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        return f(n, 1, 1) + 1;
    }

    private int f(int n, int c, int p) {
        if (c == n) {
            return 0;
        }
        if (c > n) {
            return 1001;
        }
        int ans = f(n, c + p, p) + 1;
        if (c > p) {
            ans = Math.min(ans, f(n, c, c) + 1);
        }
        return ans;
    }

}
