package io.huhu.leetcode.n5;

class TwoPointer implements Code {

    @Override
    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int i = 0, m = 0;
        for (int j = 0; j < n - (m >> 1); j++) {
            int l = j - 1, r = j + 1, len = 1;
            while (l >= 0 && c[l] == c[j]) {
                l--;
                len++;
            }
            while (r < n && c[r] == c[j]) {
                r++;
                len++;
            }
            while (l >= 0 && r < n && c[l] == c[r]) {
                l--;
                r++;
                len += 2;
            }
            if (len > m) {
                m = len;
                i = l;
            }
        }
        return s.substring(i + 1, i + 1 + m);
    }

}
