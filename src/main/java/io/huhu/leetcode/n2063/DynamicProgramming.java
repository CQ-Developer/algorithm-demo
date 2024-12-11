package io.huhu.leetcode.n2063;

import io.huhu.AC;

@AC
class DynamicProgramming implements Solution {

    private static final boolean[] M = {
            true, false, false, false, true, false,
            false, false, true, false, false, false,
            false, false, true, false, false, false,
            false, false, true, false, false, false,
            false, false};

    @Override
    public long countVowels(String word) {
        long dp = 0, res = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (M[c - 'a']) {
                dp += i + 1;
            }
            res += dp;
        }
        return res;
    }

}
