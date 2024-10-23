package io.huhu.other.n1;

class Validator implements Code {

    @Override
    public int max(int n, int k) {
        if (k == 1) {
            return n;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n && (n - i) >= (k - 1); i++) {
            ans = Math.max(ans, i * max(n - i, k - 1));
        }
        return ans;
    }

}
