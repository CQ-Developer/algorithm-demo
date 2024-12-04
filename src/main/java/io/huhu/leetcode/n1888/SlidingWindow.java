package io.huhu.leetcode.n1888;

import io.huhu.AC;

@AC
class SlidingWindow implements Code {

    private static final char[] C = {'0', '1'};

    @Override
    public int minFlips(String s) {
        char[] c = s.toCharArray();
        int n = c.length, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] != C[i % 2]) {
                cnt++;
            }
        }
        int ans = Math.min(cnt, n - cnt);
        if ((n & 1) == 0) {
            return ans;
        }
        for (int i = 0; i < n; i++) {
            if (c[i] == C[i % 2]) {
                cnt++;
            } else {
                cnt--;
            }
            ans = Math.min(ans, Math.min(cnt, n - cnt));
        }
        return ans;
    }

}
