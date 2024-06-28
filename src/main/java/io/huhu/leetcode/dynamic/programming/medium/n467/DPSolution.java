package io.huhu.leetcode.dynamic.programming.medium.n467;

final class DPSolution extends Solution {

    @Override
    public int findSubstringInWraproundString(String s) {
        int[] f = new int[26];
        int n = 0, p = -1;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (i == p + 1 || (p == 25 && i == 0)) {
                n++;
            } else {
                n = 1;
            }
            if (n > f[i]) {
                f[i] = n;
            }
            p = i;
        }
        int sum = 0;
        for (int i : f) {
            sum += i;
        }
        return sum;
    }

}
