package io.huhu.leetcode.n838;

class TwoPointers implements Code {

    @Override
    public String pushDominoes(String dominoes) {
        char[] c = dominoes.toCharArray();
        int n = c.length;
        for (int l = 0; l < n; l++) {
            if (c[l] == '.') {
                int r = l;
                while (r + 1 < n && c[r + 1] == '.') {
                    r++;
                }
                char left = l - 1 >= 0 ? c[l - 1] : 'L';
                char right = r + 1 < n ? c[r + 1] : 'R';
                if (left == right) {
                    for (int i = l; i <= r; i++) {
                        c[i] = left;
                    }
                } else if (left == 'R' && right == 'L') {
                    int cnt = (r - l + 1) / 2;
                    for (int i = 0; i < cnt; i++) {
                        c[l + i] = 'R';
                        c[r - i] = 'L';
                    }
                }
            }
        }
        return String.valueOf(c);
    }

}
