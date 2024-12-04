package io.huhu.leetcode.n1888;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    /**
     * <a href="https://leetcode.cn/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/solutions/1383188/by-nayuta-c0-xujq/">
     * review
     * </a>
     */
    @Override
    public int minFlips(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int f0 = 0, f1 = 0;
        for (int i = 0; i < n; i++) {
            int j = chars[i] - '0';
            if ((i & 1) == 0) {
                f0 += j;
                f1 += j ^ 1;
            } else {
                f0 += j ^ 1;
                f1 += j;
            }
        }
        int ans = Math.min(f0, f1);
        if ((n & 1) == 0) {
            return ans;
        }
        for (char c : chars) {
            int f = c == '1' ? 1 : -1, _f0 = f0;
            f0 = f1 + f;
            f1 = _f0 - f;
            ans = Math.min(ans, Math.min(f0, f1));
        }
        return ans;
    }

}
