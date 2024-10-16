package io.huhu.leetcode.n647;

class TP implements Code {

    /**
     * 中心扩散
     */
    @Override
    public int countSubstrings(String s) {
        char[] c = s.toCharArray();
        int n = c.length, ans = 0;
        // 基数中心 bab
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && c[l] == c[r]) {
                l--;
                r++;
                ans++;
            }
        }
        // 偶数中心 aa
        for (int i = 0; i < n; i++) {
            int l = i, r = i + 1;
            while (l >= 0 && r < n && c[l] == c[r]) {
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }

}
