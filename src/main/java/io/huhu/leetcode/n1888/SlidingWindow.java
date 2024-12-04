package io.huhu.leetcode.n1888;

import io.huhu.AC;

@AC
class SlidingWindow implements Code {

    private static final char[] C = {'0', '1'};

    /**
     * <a href="https://leetcode.cn/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/solutions/815295/minimum-number-of-flips-by-ikaruga-lu32/">
     * review
     * </a>
     */
    @Override
    public int minFlips(String s) {
        char[] c = s.toCharArray();
        int n = c.length, cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += c[i] ^ C[i & 1];
        }
        int ans = Math.min(cnt, n - cnt);
        if ((n & 1) == 0) {
            return ans;
        }
        for (int i = 1; i < n; i++) {
            cnt -= c[i - 1] ^ C[(i - 1) & 1];
            cnt += c[i - 1] ^ C[i & 1];
            ans = Math.min(ans, Math.min(cnt, n - cnt));
        }
        return ans;
    }

}
