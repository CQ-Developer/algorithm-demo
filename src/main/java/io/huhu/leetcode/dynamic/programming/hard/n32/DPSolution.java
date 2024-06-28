package io.huhu.leetcode.dynamic.programming.hard.n32;

final class DPSolution extends Solution {

    @Override
    public int longestValidParentheses(String s) {
        int ans = 0;
        int[] f = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '(') {
                if (s.charAt(i - 1) == '(') {
                    f[i] = 2;
                    if (i - 2 >= 0) {
                        f[i] += f[i - 2];
                    }
                } else {
                    if (f[i - 1] != 0) {
                        int j = i - 1 - f[i - 1];
                        if (j >= 0) {
                            if (s.charAt(j) == '(') {
                                f[i] = f[i - 1] + 2;
                                if (j - 1 >= 0) {
                                    f[i] += f[j - 1];
                                }
                            }
                        }

                    }
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

}
