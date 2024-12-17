package io.huhu.leetcode.n2305;

import io.huhu.AC;

@AC
class BT implements Solution {

    private int res = Integer.MAX_VALUE;

    @Override
    public int distributeCookies(int[] cookies, int k) {
        f(cookies, 0, new int[k], k);
        return res;
    }

    private void f(int[] cookies, int i, int[] children, int k) {
        if (i == cookies.length) {
            int mx = Integer.MIN_VALUE;
            for (int child : children) {
                mx = Math.max(mx, child);
            }
            res = Math.min(res, mx);
        } else {
            for (int j = 0; j < k; j++) {
                if (children[j] + cookies[i] > res) {
                    continue;
                }
                if (j > 0 && children[j] == children[j - 1]) {
                    continue;
                }
                children[j] += cookies[i];
                f(cookies, i + 1, children, k);
                children[j] -= cookies[i];
            }
        }
    }

}
