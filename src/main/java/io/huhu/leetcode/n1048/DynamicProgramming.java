package io.huhu.leetcode.n1048;

import io.huhu.TLE;

import java.util.Arrays;

@TLE
class DynamicProgramming implements Code {

    @Override
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int ans = 1;
        int n = words.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (words[j].length() + 1 == words[i].length() && check(words[j], words[i])) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    private boolean check(String w1, String w2) {
        return f(w1, w2, 0, 0) == 1;
    }

    private int f(String w1, String w2, int i, int j) {
        if (i == w1.length() || j == w2.length()) {
            return w1.length() - i + w2.length() - j;
        }
        if (w1.charAt(i) == w2.charAt(j)) {
            return f(w1, w2, i + 1, j + 1);
        }
        return Math.min(f(w1, w2, i + 1, j), f(w1, w2, i, j + 1)) + 1;
    }

}
