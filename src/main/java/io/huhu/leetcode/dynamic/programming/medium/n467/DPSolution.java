package io.huhu.leetcode.dynamic.programming.medium.n467;

final class DPSolution extends Solution {

    @Override
    public int findSubstringInWraproundString(String s) {
        int[] c = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(i) - 'a';
        }
        int[] f = new int[26];
        f[c[0]] = 1;
        for (int i = 1, j = 0, len = 1; i < c.length; i++, j++) {
            if ((c[i] == 0 && c[j] == 25) || c[i] == c[j] + 1) {
                len++;
            } else {
                len = 1;
            }
            f[c[i]] = Math.max(f[c[i]], len);
        }
        int sum = 0;
        for (int i : f) {
            sum += i;
        }
        return sum;
    }

}
