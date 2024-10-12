package io.huhu.leetcode.n467;

class DP implements Code {

    @Override
    public int findSubstringInWraproundString(String s) {
        int[] f = new int[26];
        int p = -1, n = 0;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (i == p + 1 || (i == 0 && p == 25)) {
                n++;
            } else {
                n = 1;
            }
            if (n > f[i]) {
                f[i] = n;
            }
            p = i;
        }
        int ans = 0;
        for (int record : f) {
            ans += record;
        }
        return ans;
    }

}
