package io.huhu.leetcode.n2063;

import io.huhu.AC;

@AC
class Greedy implements Solution {

    private static final boolean[] M = {
            true, false, false, false, true, false,
            false, false, true, false, false, false,
            false, false, true, false, false, false,
            false, false, true, false, false, false,
            false, false};

    @Override
    public long countVowels(String word) {
        int n = word.length();
        long res = 0;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (M[c - 'a']) {
                res += (long) (i + 1) * (n - i);
            }
        }
        return res;
    }

}
