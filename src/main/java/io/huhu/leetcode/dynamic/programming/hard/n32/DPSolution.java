package io.huhu.leetcode.dynamic.programming.hard.n32;

final class DPSolution extends Solution {

    @Override
    public int longestValidParentheses(String s) {
        int ans = 0;
        int[] f = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int j = i - f[i - 1] - 1;
                if (j >= 0 && s.charAt(j) == '(') {
                    f[i] = f[i - 1] + 2 + (j > 0 ? f[j - 1] : 0);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

}
