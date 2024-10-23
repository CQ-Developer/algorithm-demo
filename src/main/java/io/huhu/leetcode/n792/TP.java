package io.huhu.leetcode.n792;

class TP implements Code {

    @Override
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        char[] _s = s.toCharArray();
        for (String w : words) {
            char[] _w = w.toCharArray();
            int i = 0, j = 0;
            while (i < _s.length && j < _w.length) {
                if (_s[i] == _w[j]) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            if (j == _w.length) {
                ans++;
            }
        }
        return ans;
    }

}
