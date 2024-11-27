package io.huhu.leetcode.n1639;

import io.huhu.AC;

@AC
class BruteForceSearch implements Code {

    @Override
    public int countSubstrings(String s, String t) {
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        int m = sc.length, n = tc.length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (sc[i] != tc[j]) {
                    int l = 0;
                    while (i - l > 0 && j - l > 0 && sc[i - l - 1] == tc[j - l - 1]) {
                        l++;
                    }
                    int r = 0;
                    while (i + r + 1 < m && j + r + 1 < n && sc[i + r + 1] == tc[j + r + 1]) {
                        r++;
                    }
                    ans += (l + 1) * (r + 1);
                }
            }
        }
        return ans;
    }

}
