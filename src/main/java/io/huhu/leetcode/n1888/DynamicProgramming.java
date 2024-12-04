package io.huhu.leetcode.n1888;

class DynamicProgramming implements Code {

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
            int _f0 = f0;
            if (c == '1') {
                f0 = f1 + 1;
                f1 = _f0 - 1;
                ans = Math.min(ans, f1);
            } else {
                f0 = f1 - 1;
                f1 = _f0 + 1;
                ans = Math.min(ans, f0);
            }
        }
        return ans;
    }

}
