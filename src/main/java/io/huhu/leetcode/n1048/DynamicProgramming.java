package io.huhu.leetcode.n1048;

import io.huhu.AC;

import java.util.Arrays;

@AC
class DynamicProgramming implements Code {

    @Override
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length, ans = 0;
        int[] f = new int[n];
        for (int i = 0, l = 0; i < n; i++) {
            f[i] = 1;
            while (l < i && words[l].length() + 1 < words[i].length()) {
                l++;
            }
            int r = l;
            while (r < i && words[r].length() + 1 == words[i].length()) {
                r++;
            }
            for (int j = l; j < r; j++) {
                if (isChain(words[j], words[i])) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    private boolean isChain(String pre, String cur) {
        int i = 0;
        while (i < pre.length()) {
            if (pre.charAt(i) != cur.charAt(i)) {
                break;
            }
            i++;
        }
        while (i < pre.length()) {
            if (pre.charAt(i) != cur.charAt(i + 1)) {
                return false;
            }
            i++;
        }
        return true;
    }

}
